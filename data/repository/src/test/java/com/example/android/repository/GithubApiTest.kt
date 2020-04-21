package com.example.android.repository

import com.example.android.api.di.DaggerGithubApiComponent
import com.example.android.repository.di.DaggerGithubRepositoryComponent
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GithubApiTest {

    lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        val githubApi = DaggerGithubApiComponent.create().githubApi()
        repository = DaggerGithubRepositoryComponent.factory().create(githubApi).githubRepository()
    }

    @Test
    fun test() {

        val target = ""
        runBlocking {
            val repos = repository.myRepos()
            assertThat(target)
                .`as`("")
                .isEqualTo(repos.first().name)
        }

    }
}
