package com.example.android.api

import com.example.android.api.di.Repo
import retrofit2.http.GET
import retrofit2.http.Header

interface GithubApi {

    @GET("/user/repos")
    fun fetchMyRepos(@Header("Authorization") accessToken: String): Repo
}