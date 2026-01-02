package com.example.lojasocial_app.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.mapper.toDomain
import com.example.lojasocial_app.data.remote.api.DeliveryApi
import com.example.lojasocial_app.domain.model.delivery.Delivery

class DeliveryRepository(
    private val api: DeliveryApi
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getDeliveries(): List<Delivery> =
        api.getDeliveries().map { it.toDomain() }
}