package com.example.lojasocial_app.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.remote.dto.auth.LoginResponseDto
import com.example.lojasocial_app.domain.model.auth.Session

import java.time.LocalDateTime
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
fun LoginResponseDto.toDomain(): Session =
    Session(
        id = UUID.fromString(session_id),
        collaboratorId = UUID.randomUUID(), // vem do token/backend depois
        createdAt = LocalDateTime.now(),
        expiresAt = LocalDateTime.parse(expires_at),
        active = true
    )