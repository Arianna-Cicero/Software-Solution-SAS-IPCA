package com.example.lojasocial_app.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.mapper.toDomain
import com.example.lojasocial_app.data.remote.api.AuthApi
import com.example.lojasocial_app.data.remote.dto.auth.LoginRequestDto
import com.example.lojasocial_app.domain.model.auth.Session

class AuthRepository(
    private val api: AuthApi
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun login(
        email: String,
        password: String
    ): Session {
        val response = api.login(
            LoginRequestDto(
                email = email,
                password = password
            )
        )
        return response.toDomain()
    }
}

