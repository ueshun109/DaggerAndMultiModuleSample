package com.example.android.repository

import com.example.android.api.GithubApi
import com.example.android.model.entity.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
): GithubRepository {

    val yourAccessToken = ""

    override suspend fun myRepos(): Response<List<Repo>> = withContext(Dispatchers.IO) {
        return@withContext githubApi.fetchMyRepos("token $yourAccessToken").await()
    }
}