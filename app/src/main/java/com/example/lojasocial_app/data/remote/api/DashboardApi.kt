package com.example.lojasocial_app.data.remote.api

import com.example.lojasocial_app.data.remote.dto.dashboard.DashboardOverviewDto
import retrofit2.http.GET

interface DashboardApi {

    @GET("dashboard/overview")
    suspend fun getOverview(): DashboardOverviewDto
}

