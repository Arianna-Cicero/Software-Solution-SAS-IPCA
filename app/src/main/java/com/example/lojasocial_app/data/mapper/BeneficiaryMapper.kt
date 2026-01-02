package com.example.lojasocial_app.data.mapper


import com.example.lojasocial_app.data.remote.dto.beneficiary.BeneficiaryDto
import com.example.lojasocial_app.domain.model.beneficiary.Beneficiary
import com.example.lojasocial_app.domain.model.beneficiary.Course

fun BeneficiaryDto.toDomain(): Beneficiary =
    Beneficiary(
        id = id_beneficiary,
        name = name,
        studentNumber = student_number,
        email = email,
        telephone = telephone,
        course = Course(
            id = 0, // não vem da API
            name = course_name
        )
    )

