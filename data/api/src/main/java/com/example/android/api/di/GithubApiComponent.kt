package com.example.android.api.di

import com.example.android.api.GithubApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GithubApiModule::class])
interface GithubApiComponent {
    fun myProfileApi(): GithubApi

    @Component.Factory
    interface Factory {
        fun create(): GithubApiComponent
    }

    companion object {
        fun factory(): Factory = DaggerGithubApiComponent.factory()
    }
}