package com.example.android.repository

import com.example.android.model.entity.Repo


interface GithubRepository {
    suspend fun myRepos(): List<Repo>
}