package com.example.lojasocial_app.data.remote.dto.dashboard

data class DashboardOverviewDto(
    val active_beneficiaries: Int,
    val current_stock: Int,
    val pending_deliveries: Int,
    val next_pickups: Int
)