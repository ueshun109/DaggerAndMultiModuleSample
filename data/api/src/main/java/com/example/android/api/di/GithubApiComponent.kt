package com.example.android.api.di

import com.example.android.api.GitHubMyProfileApi
import com.example.android.api.GithubApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GithubApiModule::class])
interface GithubApiComponent {
    fun myProfileApi(): GitHubMyProfileApi

    @Component.Factory
    interface Factory {
        fun create(): GithubApiComponent
    }

    companion object {
        fun factory(): Factory = DaggerGithubApiComponent.factory()
    }
}