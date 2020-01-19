package com.example.android.daggerandmultimodulesample.di

import com.example.android.api.GitHubMyProfileApi
import com.example.android.api.di.GithubApiComponent
import dagger.Module
import dagger.Provides

@Module
object GithubApiComponentModule {
    @Provides
    fun provideMyProfileApi(): GitHubMyProfileApi {
        return GithubApiComponent.factory()
            .create()
            .myProfileApi()
    }
}