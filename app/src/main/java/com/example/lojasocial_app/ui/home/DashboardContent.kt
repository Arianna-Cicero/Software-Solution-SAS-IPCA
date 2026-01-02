package com.example.lojasocial_app.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lojasocial_app.domain.model.dashboard.DashboardOverview

@Composable
fun DashboardContent(
    dashboard: DashboardOverview
) {
    Column {
        DashboardCard(
            title = "Beneficiários Ativos",
            value = dashboard.activeBeneficiaries.toString()
        )
        DashboardCard(
            title = "Stock Atual",
            value = dashboard.currentStock.toString()
        )
        DashboardCard(
            title = "Entregas Pendentes",
            value = dashboard.pendingDeliveries.toString()
        )
        DashboardCard(
            title = "Próximas Recolhas",
            value = dashboard.nextPickups.toString()
        )
    }
}

@Composable
private fun DashboardCard(
    title: String,
    value: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title)
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}