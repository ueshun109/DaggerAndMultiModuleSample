package com.example.android.use_case

import com.example.android.model.entity.Repo
import com.example.android.repository.GithubRepository
import javax.inject.Inject

class GithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun getRepository(): List<Repo> = githubRepository.myRepos()
}