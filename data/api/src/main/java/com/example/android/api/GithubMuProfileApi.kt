package com.example.android.api

import com.example.android.api.di.Repo

interface GitHubMyProfileApi {
    fun fetchMyProfile(): Repo
}