package com.example.lojasocial_app.domain.model.dashboard

data class DashboardOverview(
    val activeBeneficiaries: Int,
    val currentStock: Int,
    val pendingDeliveries: Int,
    val nextPickups: Int
)

