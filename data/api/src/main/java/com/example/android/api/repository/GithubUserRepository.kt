package com.example.android.repository

import com.example.android.api.GitHubRepoApi
import javax.inject.Inject

class GithubUserRepository @Inject constructor(
    private val gitHubRepoApi: GitHubRepoApi
) {
    fun fetchUser() {
        gitHubRepoApi.fetchRepos()
    }
}