package com.example.android.repository

import com.example.android.api.GitHubMyProfileApi
import javax.inject.Inject

class GithubUserRepository @Inject constructor(
    private val gitHubRepoApi: GitHubMyProfileApi
) {
    fun fetchUser() {
        gitHubRepoApi.fetchMyProfile()
    }
}