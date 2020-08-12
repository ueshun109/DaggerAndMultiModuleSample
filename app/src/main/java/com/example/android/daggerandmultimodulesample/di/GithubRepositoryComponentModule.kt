package com.example.android.daggerandmultimodulesample.di

import com.example.android.api.GithubApi
import com.example.android.repository.di.GithubRepositoryComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object GithubRepositoryComponentModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideGithubRepositoryComponent(githubApi: GithubApi): GithubRepositoryComponent =
        GithubRepositoryComponent.factory().create(githubApi)

    @JvmStatic
    @Provides
    fun provideGithubRepository(githubRepositoryComponent: GithubRepositoryComponent) =
        githubRepositoryComponent.githubRepository()
}