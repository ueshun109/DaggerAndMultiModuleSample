package com.example.android.repository.di

import com.example.android.api.GithubApi
import com.example.android.repository.GithubRepository
import dagger.BindsInstance
import dagger.Component

@Component(modules = [GithubRepositoryModule::class])
interface GithubRepositoryComponent {

    fun githubRepository(): GithubRepository

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance githubApi: GithubApi
        ): GithubRepositoryComponent
    }
}