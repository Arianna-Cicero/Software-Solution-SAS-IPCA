package com.example.lojasocial_app.data.remote.api

import com.example.lojasocial_app.data.remote.dto.beneficiary.BeneficiaryDto
import retrofit2.http.GET

interface BeneficiaryApi {

    @GET("beneficiaries")
    suspend fun getBeneficiaries(): List<BeneficiaryDto>
}
