package com.example.android.daggerandmultimodulesample.di

import com.example.android.api.GithubApi
import com.example.android.api.di.GithubApiComponent
import dagger.Module
import dagger.Provides

@Module
object GithubApiComponentModule {
    @Provides
    fun provideMyProfileApi(): GithubApi {
        return GithubApiComponent.factory()
            .create()
            .githubApi()
    }
}