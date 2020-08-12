package com.example.android.daggerandmultimodulesample.di

import android.app.Application
import android.content.Context
import com.example.android.daggerandmultimodulesample.App
import com.example.android.daggerandmultimodulesample.MainActivity
import com.example.android.use_case.di.UseCaseComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    GithubApiComponentModule::class,
    GithubRepositoryComponentModule::class
])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}