package com.example.lojasocial_app.data.remote.dto.beneficiary

data class BeneficiaryDto(
    val id_beneficiary: Int,
    val name: String,
    val student_number: Int,
    val email: String,
    val telephone: String,
    val course_name: String
)