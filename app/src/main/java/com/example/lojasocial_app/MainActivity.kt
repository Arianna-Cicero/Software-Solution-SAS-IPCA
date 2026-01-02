package com.example.lojasocial_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.lojasocial_app.core.navigation.NavGraph
import com.example.lojasocial_app.core.navigation.Screen
import com.example.lojasocial_app.core.ui.components.BottomBar
import com.example.lojasocial_app.data.remote.api.*
import com.example.lojasocial_app.data.repository.*
import com.example.lojasocial_app.data.session.AuthEventBus
import com.example.lojasocial_app.data.session.SessionManager
import com.example.lojasocial_app.domain.usecase.auth.LoginUseCase
import com.example.lojasocial_app.domain.usecase.dashboard.GetDashboardOverviewUseCase
import com.example.lojasocial_app.ui.home.HomeViewModel
import com.example.lojasocial_app.ui.login.LoginViewModel
import com.example.lojasocial_app.ui.theme.SocialAppTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SocialAppTheme {

                /* ---------------- Session ---------------- */
                val sessionManager = remember {
                    SessionManager(applicationContext)
                }

                val sessionId by sessionManager
                    .getSessionId()
                    .collectAsState(initial = null)

                /* ---------------- Navigation ---------------- */
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                /* ---------------- Retrofit ---------------- */
                val authApi = remember {
                    RetrofitClient.createAuthApi()
                }

                val dashboardApi = remember {
                    RetrofitClient.createDashboardApi(sessionManager)
                }

                /* ---------------- Repositories ---------------- */
                val authRepository = remember {
                    AuthRepository(authApi)
                }

                val dashboardRepository = remember {
                    DashboardRepository(dashboardApi)
                }

                /* ---------------- UseCases ---------------- */
                val loginUseCase = remember {
                    LoginUseCase(authRepository)
                }

                val dashboardUseCase = remember {
                    GetDashboardOverviewUseCase(dashboardRepository)
                }

                /* ---------------- ViewModels ---------------- */
                val loginViewModel = remember {
                    LoginViewModel(
                        loginUseCase = loginUseCase,
                        sessionManager = sessionManager
                    )
                }

                val homeViewModel = remember {
                    HomeViewModel(dashboardUseCase)
                }

                /* ---------------- UI ---------------- */
                Scaffold(
                    bottomBar = {
                        if (currentRoute != Screen.Login.route) {
                            BottomBar(navController)
                        }
                    }
                ) { paddingValues ->

                    NavGraph(
                        navController = navController,
                        loginViewModel = loginViewModel,
                        homeViewModel = homeViewModel,
                        modifier = Modifier.padding(paddingValues),
                        startDestination = if (sessionId == null) {
                            Screen.Login.route
                        } else {
                            Screen.Home.route
                        },
                        sessionManager = sessionManager
                    )
                }
                LaunchedEffect(Unit) {
                    AuthEventBus.unauthorizedEvent.collect {
                        sessionManager.clearSession()
                        navController.navigate(Screen.Login.route) {
                            popUpTo(0)
                        }
                    }
                }
            }
        }
    }
}
