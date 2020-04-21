package com.example.android.api.di

import com.example.android.api.GithubApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object GithubApiModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpLogging(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor {
                it.proceed(it.request().apply {
                    newBuilder()
                        .method(method(), body())
                        .build()
                })
            }
            .build()

    @Provides
    @JvmStatic
    @Singleton
    fun provideGithubRepo(okHttpClient: OkHttpClient, moshi: Moshi) : GithubApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
            .create(GithubApi::class.java)
    }
}