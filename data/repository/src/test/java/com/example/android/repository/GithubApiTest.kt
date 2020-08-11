package com.example.android.repository

import com.example.android.api.GithubApi
import com.example.android.api.di.DaggerGithubApiComponent
import com.example.android.repository.di.DaggerGithubRepositoryComponent
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test

import org.junit.Before
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GithubApiTest {

    private val mockWebServer = MockWebServer()
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        val dispatcher: Dispatcher = object: Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().setResponseCode(200).setBodyFromFileName("github_my_repositories.json")
            }
        }
        mockWebServer.dispatcher = dispatcher
        mockWebServer.start()

        val githubApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(GithubApi::class.java)

        repository = GithubRepositoryImpl(githubApi)
    }

    @Test
    fun fetch_myRepos_success() {
        val target = "certificates"
        runBlocking {
            val repos = repository.myRepos()
            assertThat(target)
                .`as`("取得したリポジトリ一覧の最初のリポジトリ名がcertificatesであること")
                .isEqualTo(repos.body()!!.first().name)
        }
    }

    @Test(expected = HttpException::class)
    fun fetch_myRepos_failure() {
        val dispatcher: Dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().setResponseCode(401)
            }
        }
        mockWebServer.dispatcher = dispatcher
        runBlocking { repository.myRepos() }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
