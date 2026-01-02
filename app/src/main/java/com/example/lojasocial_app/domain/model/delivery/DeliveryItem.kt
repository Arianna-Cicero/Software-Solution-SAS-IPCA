package com.example.lojasocial_app.domain.model.delivery

data class DeliveryItem(
    val deliveryId: java.util.UUID,
    val goodId: Int,
    val quantity: Int
)

