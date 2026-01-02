package com.example.lojasocial_app.domain.model.delivery

import java.time.LocalDate
import java.util.UUID

data class Scheduling(
    val id: Int,
    val beneficiaryId: Int,
    val collaboratorId: UUID,
    val deliveryDate: LocalDate,
    val status: String
)
