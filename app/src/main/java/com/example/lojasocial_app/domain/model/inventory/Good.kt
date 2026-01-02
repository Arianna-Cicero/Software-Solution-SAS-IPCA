package com.example.lojasocial_app.domain.model.inventory

import java.time.LocalDate

data class Good(
    val id: Int,
    val name: String,
    val category: String,
    val quantity: Int,
    val intakeDate: LocalDate,
    val validUntil: LocalDate,
    val status: String
)