package com.example.lojasocial_app.data.repository

import com.example.lojasocial_app.data.mapper.toDomain
import com.example.lojasocial_app.data.remote.api.DashboardApi
import com.example.lojasocial_app.domain.model.dashboard.DashboardOverview

class DashboardRepository(
    private val api: DashboardApi
) {

    suspend fun getOverview(): DashboardOverview =
        api.getOverview().toDomain()
}

