package com.example.lojasocial_app.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.remote.dto.delivery.DeliveryDto
import com.example.lojasocial_app.domain.model.delivery.Delivery
import java.time.LocalDate
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
fun DeliveryDto.toDomain(): Delivery =
    Delivery(
        id = UUID.fromString(id_delivery),
        schedulingId = 0, // não exposto na API
        deliveryDate = LocalDate.parse(delivery_date),
        status = status
    )
