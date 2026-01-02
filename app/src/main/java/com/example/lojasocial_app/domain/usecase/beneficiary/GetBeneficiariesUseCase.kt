package com.example.lojasocial_app.domain.usecase.beneficiary

import com.example.lojasocial_app.data.repository.BeneficiaryRepository
import com.example.lojasocial_app.domain.model.beneficiary.Beneficiary

class GetBeneficiariesUseCase(
    private val repository: BeneficiaryRepository
) {

    suspend operator fun invoke(): List<Beneficiary> {
        return repository.getBeneficiaries()
    }
}

