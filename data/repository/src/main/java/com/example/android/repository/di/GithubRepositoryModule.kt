package com.example.android.repository.di

import com.example.android.repository.GithubRepository
import com.example.android.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface GithubRepositoryModule {
    @Binds
    fun bindGithubRepository(impl: GithubRepositoryImpl): GithubRepository
}