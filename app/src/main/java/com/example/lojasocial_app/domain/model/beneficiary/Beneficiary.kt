package com.example.lojasocial_app.domain.model.beneficiary

data class Beneficiary(
    val id: Int,
    val name: String,
    val studentNumber: Int,
    val email: String,
    val telephone: String,
    val course: Course
)
