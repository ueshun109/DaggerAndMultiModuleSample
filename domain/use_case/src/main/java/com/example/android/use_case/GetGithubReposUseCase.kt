package com.example.android.use_case

import androidx.annotation.VisibleForTesting
import com.example.android.core.GithubError
import com.example.android.model.entity.Repo
import com.example.android.repository.GithubRepository
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import org.jetbrains.annotations.TestOnly
import retrofit2.HttpException
import java.net.HttpURLConnection
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    private val _githubRepositories = BroadcastChannel<Result<List<Repo>>>(Channel.BUFFERED)
    val githubRepositories = _githubRepositories.asFlow()

    @VisibleForTesting
    var responseState: GithubError? = null
        private set

    suspend fun execute() {
        runCatching {
            githubRepository.myRepos()
        }.onSuccess { response ->
            val body = response.body()
            if (body != null) {
                _githubRepositories.offer(Result.success(body))
            } else {
                _githubRepositories.offer(Result.failure(GithubError.UnknownError))
            }
        }.onFailure { error ->
            if (error is HttpException) {
                when(error.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> {
                        responseState = GithubError.UnAuthorized
                        _githubRepositories.offer(Result.failure(GithubError.UnAuthorized))
                    }
                    HttpURLConnection.HTTP_FORBIDDEN -> {
                        responseState = GithubError.Forbidden
                        _githubRepositories.offer(Result.failure(GithubError.Forbidden))
                    }
                    HttpURLConnection.HTTP_INTERNAL_ERROR -> {
                        responseState = GithubError.InternalServerError
                        _githubRepositories.offer(Result.failure(GithubError.InternalServerError))
                    }
                }
            } else {
                _githubRepositories.offer(Result.failure(GithubError.UnknownError))
            }
        }
    }
}