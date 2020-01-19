package com.example.android.daggerandmultimodulesample.di

import com.example.android.repos.UserViewModel
import dagger.Component

@Component(modules = [GithubApiComponentModule::class])
interface AppComponent {
    fun inject(viewModel: UserViewModel)
}