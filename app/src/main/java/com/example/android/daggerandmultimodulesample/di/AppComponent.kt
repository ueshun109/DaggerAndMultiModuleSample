package com.example.android.daggerandmultimodulesample.di

import com.example.android.daggerandmultimodulesample.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ViewModelModule::class,
    GithubApiComponentModule::class,
    GithubRepositoryComponentModule::class
])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}