package com.example.android.use_case.di

import com.example.android.repository.GithubRepository
import com.example.android.use_case.GetGithubReposUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UseCaseModule::class])
interface UseCaseComponent {

    fun githubReposUseCase(): GetGithubReposUseCase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance githubRepository: GithubRepository
        ): UseCaseComponent
    }
}