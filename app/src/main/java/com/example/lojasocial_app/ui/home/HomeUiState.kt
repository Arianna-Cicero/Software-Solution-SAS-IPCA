package com.example.lojasocial_app.ui.home

import com.example.lojasocial_app.domain.model.dashboard.DashboardOverview

data class HomeUiState(
    val isLoading: Boolean = false,
    val dashboard: DashboardOverview? = null,
    val error: String? = null,
    val shouldLogout: Boolean = false
)