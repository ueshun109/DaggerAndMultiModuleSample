package com.example.android.use_case

import com.example.android.repository.GithubUserRepository
import javax.inject.Inject

class GithubUserUseCase @Inject constructor(
    private val repository: GithubUserRepository
){
    fun fetchUser() {
        repository.fetchUser()
    }
}