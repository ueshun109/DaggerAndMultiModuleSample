package com.example.android.repos.di

import com.example.android.repos.RepoListFragment
import dagger.Subcomponent

@Subcomponent
interface RepoListComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): RepoListComponent
    }

    fun inject(repoListFragment: RepoListFragment)
}