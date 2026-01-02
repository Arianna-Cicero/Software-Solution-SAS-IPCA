package com.example.lojasocial_app.domain.usecase.auth

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.repository.AuthRepository
import com.example.lojasocial_app.domain.model.auth.Session

class LoginUseCase(
    private val repository: AuthRepository
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(
        email: String,
        password: String
    ): Session {
        return repository.login(email, password)
    }
}