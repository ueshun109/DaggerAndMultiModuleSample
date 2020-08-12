package com.example.android.daggerandmultimodulesample.di

import com.example.android.api.GithubApi
import com.example.android.api.di.GithubApiComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object GithubApiComponentModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideMyProfileApi(): GithubApi {
        return GithubApiComponent.factory()
            .create()
            .githubApi()
    }
}