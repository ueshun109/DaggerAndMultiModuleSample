package com.example.android.repository.di

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Retrofitで定義されている[Call]型の拡張関数
 * コールバックの処理をコルーチンで置き換えたもの
 */
suspend fun <T> Call<T>.await(): T {
    return kotlinx.coroutines.suspendCancellableCoroutine { continuation ->
        continuation.invokeOnCancellation {
            cancel()
        }

        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        continuation.resume(it)
                    } ?: continuation.resumeWithException(Exception())
                } else {
                    continuation.resumeWithException(HttpException(response))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                if (continuation.isCancelled || continuation.isActive.not()) {
                    return
                }
                continuation.resumeWithException(t)
            }
        })
    }
}