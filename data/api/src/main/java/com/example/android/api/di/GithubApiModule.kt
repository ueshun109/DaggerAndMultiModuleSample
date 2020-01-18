package com.example.android.api

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object GithubApiModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideGithubRepo(okHttpClient: OkHttpClient, moshi: Moshi) : GitHubRepoApi {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
            .create(GitHubRepoApi::class.java)
    }
}

data class Repo(
    val aaa: String
)