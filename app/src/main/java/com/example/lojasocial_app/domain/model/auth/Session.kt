package com.example.lojasocial_app.domain.model.auth

import java.time.LocalDateTime
import java.util.UUID

data class Session(
    val id: UUID,
    val collaboratorId: UUID,
    val createdAt: LocalDateTime,
    val expiresAt: LocalDateTime,
    val active: Boolean
)

