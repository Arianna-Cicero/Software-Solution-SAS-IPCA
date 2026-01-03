package com.example.lojasocial_app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lojasocial_app.core.navigation.Screen
import com.example.lojasocial_app.data.session.SessionManager

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController,
    sessionManager: SessionManager
) {
    val state by viewModel.uiState.collectAsState()

    if (state.shouldLogout) {
        LaunchedEffect(state.shouldLogout) {
            sessionManager.clearSession()
            viewModel.onLogoutHandled()
            navController.navigate(Screen.Login.route) {
                popUpTo(0)
            }
        }
    }

    // IPCA Green color
    val ipcaGreen = Color(0xFF1B5E20)
    val lightGreen = Color(0xFF2E7D32)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Header with IPCA logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ipcaGreen)
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "IPCA",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    letterSpacing = 4.sp
                ),
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Greeting
            Text(
                text = "Olá, Arianna",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Navigation Cards Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                NavigationCard(
                    title = "Beneficiários",
                    icon = Icons.Default.Person,
                    onClick = { navController.navigate(Screen.Beneficiaries.route) },
                    modifier = Modifier.weight(1f)
                )
                NavigationCard(
                    title = "Inventário",
                    icon = Icons.Default.Home,
                    onClick = { navController.navigate(Screen.Inventory.route) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                NavigationCard(
                    title = "Apoios",
                    icon = Icons.Default.DateRange,
                    onClick = { navController.navigate(Screen.Support.route) },
                    modifier = Modifier.weight(1f)
                )
                NavigationCard(
                    title = "Entregas",
                    icon = Icons.Default.CheckCircle,
                    onClick = { navController.navigate(Screen.Deliveries.route) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Overview Section
            Text(
                text = "Overview",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Overview Statistics Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    when {
                        state.isLoading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                color = ipcaGreen
                            )
                        }
                        state.dashboard != null -> {
                            state.dashboard?.let { dashboard ->
                                OverviewStat(
                                    value = dashboard.activeBeneficiaries.toString(),
                                    label = "Beneficiários\nativos"
                                )
                                OverviewStat(
                                    value = dashboard.currentStock.toString(),
                                    label = "Stock\natual"
                                )
                                OverviewStat(
                                    value = dashboard.pendingDeliveries.toString(),
                                    label = "Entregas\npendentes"
                                )
                                OverviewStat(
                                    value = dashboard.nextPickups.toString(),
                                    label = "Próximas\nrecolhas",
                                    showCalendarIcon = true
                                )
                            }
                        }
                        state.error != null -> {
                            // Mock data for UI development
                            OverviewStat(value = "527", label = "Beneficiários\nativos")
                            OverviewStat(value = "2345", label = "Stock\natual")
                            OverviewStat(value = "12", label = "Entregas\npendentes")
                            OverviewStat(
                                value = "15",
                                label = "Próximas\nrecolhas",
                                showCalendarIcon = true
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun NavigationCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(48.dp),
                tint = Color(0xFF1B5E20)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color(0xFF1B5E20)
            )
        }
    }
}

@Composable
private fun OverviewStat(
    value: String,
    label: String,
    showCalendarIcon: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showCalendarIcon) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Calendar",
                modifier = Modifier.size(32.dp),
                tint = Color(0xFF1B5E20)
            )
        } else {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                ),
                color = Color(0xFF1B5E20)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        if (showCalendarIcon) {
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF1B5E20)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}
