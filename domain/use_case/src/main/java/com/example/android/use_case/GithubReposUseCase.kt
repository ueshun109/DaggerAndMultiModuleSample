package com.example.android.use_case

import com.example.android.repository.GithubRepository
import javax.inject.Inject

class GithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun getRepository() {
        val repos = githubRepository.myRepos()
    }
}