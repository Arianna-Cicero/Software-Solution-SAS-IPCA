package com.example.lojasocial_app.domain.model.inventory

import java.time.LocalDate

data class ExpirationAlert(
    val id: Int,
    val goodId: Int,
    val alertDate: LocalDate,
    val remainingDays: Int,
    val resolved: Boolean
)
