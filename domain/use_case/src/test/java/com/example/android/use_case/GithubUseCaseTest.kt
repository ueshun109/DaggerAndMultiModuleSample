package com.example.android.use_case

import com.example.android.api.di.DaggerGithubApiComponent
import com.example.android.repository.di.DaggerGithubRepositoryComponent
import com.example.android.use_case.di.DaggerUseCaseComponent
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GithubUseCaseTest {

    lateinit var useCase: GithubReposUseCase

    @Before
    fun setUp() {
        val githubApi = DaggerGithubApiComponent.create().githubApi()
        val repository = DaggerGithubRepositoryComponent.factory().create(githubApi).githubRepository()
        useCase = DaggerUseCaseComponent.factory().create(repository).githubReposUseCase()
    }

    @Test
    fun test() {
        val target = "certificates"
        runBlocking {
            val repos = useCase.getRepository()
            Assertions.assertThat(target)
                .`as`("")
                .isEqualTo(repos.first().name)
        }
    }
}
