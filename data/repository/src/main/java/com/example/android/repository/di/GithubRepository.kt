package com.example.android.repository.di

interface GithubRepository {
    suspend fun myRepos()
}