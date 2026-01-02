package com.example.lojasocial_app.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    val dashboard = state.dashboard

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.error != null -> {
                Text(
                    text = state.error.toString(),
                    color = MaterialTheme.colorScheme.error
                )
            }

            dashboard != null -> {
                DashboardContent(dashboard)
            }
        }
    }
}
