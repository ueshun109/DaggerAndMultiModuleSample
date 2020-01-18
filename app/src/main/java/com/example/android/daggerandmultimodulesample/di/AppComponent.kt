package com.example.android.daggerandmultimodulesample.di

import com.example.android.api.GithubApiModule
import dagger.Component

@Component(modules = [HttpClientModule::class, GithubApiModule::class])
interface AppComponent {

}