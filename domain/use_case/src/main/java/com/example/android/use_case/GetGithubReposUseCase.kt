package com.example.android.use_case

import com.example.android.core.GithubError
import com.example.android.model.entity.Repo
import com.example.android.repository.GithubRepository
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import java.net.HttpURLConnection
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    private val _githubRepositories = BroadcastChannel<Result<List<Repo>>>(Channel.BUFFERED)
    val githubRepositories = _githubRepositories.asFlow()

    suspend fun invoke() {
        val response = githubRepository.myRepos()
        when(response.code()) {
            HttpURLConnection.HTTP_OK -> {
                val body = response.body()
                if (body != null) {
                    _githubRepositories.offer(Result.success(body))
                } else {
                    _githubRepositories.offer(Result.failure(GithubError.UnknownError))
                }
            }
            HttpURLConnection.HTTP_UNAUTHORIZED -> _githubRepositories.offer(Result.failure(GithubError.UnAuthorized))
            HttpURLConnection.HTTP_FORBIDDEN -> _githubRepositories.offer(Result.failure(GithubError.Forbidden))
            HttpURLConnection.HTTP_INTERNAL_ERROR -> _githubRepositories.offer(Result.failure(GithubError.InternalServerError))
        }
    }
}