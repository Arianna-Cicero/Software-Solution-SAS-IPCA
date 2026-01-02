package com.example.lojasocial_app.data.repository

import com.example.lojasocial_app.data.mapper.toDomain
import com.example.lojasocial_app.data.remote.api.BeneficiaryApi
import com.example.lojasocial_app.domain.model.beneficiary.Beneficiary

class BeneficiaryRepository(
    private val api: BeneficiaryApi
) {

    suspend fun getBeneficiaries(): List<Beneficiary> =
        api.getBeneficiaries().map { it.toDomain() }
}

