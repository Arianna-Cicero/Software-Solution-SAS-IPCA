package com.example.lojasocial_app.domain.usecase.dashboard

import com.example.lojasocial_app.data.repository.DashboardRepository
import com.example.lojasocial_app.domain.model.dashboard.DashboardOverview

class GetDashboardOverviewUseCase(
    private val repository: DashboardRepository
) {

    suspend operator fun invoke(): DashboardOverview {
        return repository.getOverview()
    }
}