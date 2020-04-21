package com.example.android.use_case.di

import com.example.android.repository.GithubRepository
import com.example.android.use_case.GithubReposUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGithubReposUseCase(githubRepository: GithubRepository) =  GithubReposUseCase(githubRepository)
}