package com.example.android.use_case

import com.example.android.core.GithubError
import com.example.android.repository.GithubRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class GithubUseCaseTest {

    private var getGithubResponseUseCase: GetGithubReposUseCase = mockk(relaxed = true)

    @Test
    fun test() {
        runBlocking {
            getGithubResponseUseCase.execute()
            coVerify { getGithubResponseUseCase.execute() }
            confirmVerified(getGithubResponseUseCase)
        }
    }

    @Test
    fun failure_because_unAuthorize() {
        val mockRepository = mockk<GithubRepository> {
            coEvery { myRepos() } throws HttpException(
                Response.error<Any>(
                    401,
                    ResponseBody.create(MediaType.parse("text/plain"), "UnAuthorized Error")
                )
            )
        }
        getGithubResponseUseCase = GetGithubReposUseCase(mockRepository)

        runBlocking {
            getGithubResponseUseCase.execute()
            coVerify { getGithubResponseUseCase.execute() }
            assertThat(getGithubResponseUseCase.responseState!!)
                .`as`("UnAuthorize Errorであること")
                .isEqualTo(GithubError.UnAuthorized)
        }
    }

    @Test
    fun failure_because_forbidden() {
        val mockRepository = mockk<GithubRepository> {
            coEvery { myRepos() } throws HttpException(
                Response.error<Any>(
                    403,
                    ResponseBody.create(MediaType.parse("text/plain"), "Forbidden Error")
                )
            )
        }
        getGithubResponseUseCase = GetGithubReposUseCase(mockRepository)

        runBlocking {
            getGithubResponseUseCase.execute()
            coVerify { getGithubResponseUseCase.execute() }
            assertThat(getGithubResponseUseCase.responseState!!)
                .`as`("Forbidden Errorであること")
                .isEqualTo(GithubError.Forbidden)
        }
    }

    @Test
    fun failure_because_internalServerError() {
        val mockRepository = mockk<GithubRepository> {
            coEvery { myRepos() } throws HttpException(
                Response.error<Any>(
                    500,
                    ResponseBody.create(MediaType.parse("text/plain"), "Internal Server Error")
                )
            )
        }
        getGithubResponseUseCase = GetGithubReposUseCase(mockRepository)

        runBlocking {
            getGithubResponseUseCase.execute()
            coVerify { getGithubResponseUseCase.execute() }
            assertThat(getGithubResponseUseCase.responseState!!)
                .`as`("Internal Server Errorであること")
                .isEqualTo(GithubError.InternalServerError)
        }
    }
}
