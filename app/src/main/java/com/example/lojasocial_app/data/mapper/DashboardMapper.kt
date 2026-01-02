package com.example.lojasocial_app.data.mapper

import com.example.lojasocial_app.data.remote.dto.dashboard.DashboardOverviewDto
import com.example.lojasocial_app.domain.model.dashboard.DashboardOverview

fun DashboardOverviewDto.toDomain(): DashboardOverview =
    DashboardOverview(
        activeBeneficiaries = active_beneficiaries,
        currentStock = current_stock,
        pendingDeliveries = pending_deliveries,
        nextPickups = next_pickups
    )