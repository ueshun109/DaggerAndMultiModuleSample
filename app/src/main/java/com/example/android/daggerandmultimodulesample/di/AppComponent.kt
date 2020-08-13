package com.example.android.daggerandmultimodulesample.di

import com.example.android.repos.di.RepoListComponent
import com.example.android.repos.di.RepoListComponentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        RepoListComponentModule::class,
        GithubApiComponentModule::class,
        GithubRepositoryComponentModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun repoListComponent(): RepoListComponent.Factory
}