package com.example.lojasocial_app.domain.usecase.delivery

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.repository.DeliveryRepository
import com.example.lojasocial_app.domain.model.delivery.Delivery

class GetDeliveriesUseCase(
    private val repository: DeliveryRepository
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(): List<Delivery> {
        return repository.getDeliveries()
    }
}
