package com.example.lojasocial_app.data.remote.dto.auth

data class LoginResponseDto(
    val session_id: String,
    val expires_at: String
)