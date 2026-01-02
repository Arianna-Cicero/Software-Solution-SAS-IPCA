package com.example.lojasocial_app.data.remote.api

import com.example.lojasocial_app.data.remote.dto.delivery.DeliveryDto
import retrofit2.http.GET

interface DeliveryApi {

    @GET("deliveries")
    suspend fun getDeliveries(): List<DeliveryDto>
}

