package com.example.android.daggerandmultimodulesample

import android.app.Application
import com.example.android.daggerandmultimodulesample.di.DaggerAppComponent
import com.example.android.repos.di.ProviderRepoListComponent
import com.example.android.repos.di.RepoListComponent

class App: Application(), ProviderRepoListComponent {

    private val appComponent = DaggerAppComponent.create()

    override fun provideRepoListComponent(): RepoListComponent =
        appComponent.repoListComponent().create()
}