package com.example.lojasocial_app.domain.model.auth

import java.util.UUID

data class Collaborator(
    val id: UUID,
    val name: String,
    val email: String,
    val password: String,
    val profile: String,
    val active: Boolean
)
