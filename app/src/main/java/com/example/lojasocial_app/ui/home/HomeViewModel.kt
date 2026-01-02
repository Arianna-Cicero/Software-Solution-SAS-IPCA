package com.example.lojasocial_app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.lojasocial_app.domain.usecase.dashboard.GetDashboardOverviewUseCase

class HomeViewModel(
    private val getDashboardOverviewUseCase: GetDashboardOverviewUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadDashboard()
    }

    private fun loadDashboard() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                val dashboard = getDashboardOverviewUseCase()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        dashboard = dashboard
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Erro ao carregar dashboard"
                    )
                }
            }
        }
    }
}