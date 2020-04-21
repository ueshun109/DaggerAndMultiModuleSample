package com.example.android.repository.di

import com.example.android.api.GithubApi

class GithubRepositoryImpl constructor(
    private val githubApi: GithubApi
): GithubRepository {

    override suspend fun myRepos() {
        githubApi.fetchMyRepos()
    }
}