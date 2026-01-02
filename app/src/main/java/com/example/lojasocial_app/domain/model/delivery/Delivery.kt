package com.example.lojasocial_app.domain.model.delivery

import java.time.LocalDate
import java.util.UUID

data class Delivery(
    val id: UUID,
    val schedulingId: Int,
    val deliveryDate: LocalDate,
    val status: String
)

