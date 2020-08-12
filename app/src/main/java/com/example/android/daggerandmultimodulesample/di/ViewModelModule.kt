package com.example.android.daggerandmultimodulesample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.core.di.ViewModelFactory
import com.example.android.core.di.ViewModelKey
import com.example.android.repos.RepoListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel::class)
    abstract fun bindRepoListViewModel(viewModel: RepoListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelModule(factory: ViewModelFactory): ViewModelProvider.Factory
}