package com.example.android.daggerandmultimodulesample.di

import dagger.Component

@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}