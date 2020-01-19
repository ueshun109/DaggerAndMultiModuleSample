package com.example.android.repos

import androidx.lifecycle.ViewModel
import com.example.android.use_case.GithubUserUseCase
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userUseCase: GithubUserUseCase
) : ViewModel() {
    fun fetch() {
        userUseCase.fetchUser()
    }
}
