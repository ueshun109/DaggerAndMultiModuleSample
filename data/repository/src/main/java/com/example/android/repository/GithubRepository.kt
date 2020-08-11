package com.example.android.repository

import com.example.android.model.entity.Repo
import retrofit2.Response


interface GithubRepository {
    suspend fun myRepos(): Response<List<Repo>>
}