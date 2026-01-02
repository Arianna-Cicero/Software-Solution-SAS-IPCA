package com.example.lojasocial_app.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lojasocial_app.data.session.SessionManager
import com.example.lojasocial_app.ui.beneficiary.BeneficiaryListScreen
import com.example.lojasocial_app.ui.delivery.DeliveryListScreen

import com.example.lojasocial_app.ui.home.HomeScreen
import com.example.lojasocial_app.ui.login.LoginScreen
import com.example.lojasocial_app.ui.login.LoginViewModel
import com.example.lojasocial_app.ui.home.HomeViewModel
import com.example.lojasocial_app.ui.inventory.InventoryScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    homeViewModel: HomeViewModel,
    startDestination: String,
    modifier: Modifier = Modifier,
    sessionManager: SessionManager
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = loginViewModel,
                navController = navController
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = homeViewModel,
                navController = navController,
                sessionManager = sessionManager
            )
        }

        composable(Screen.Beneficiaries.route) {
            BeneficiaryListScreen()
        }

        composable(Screen.Inventory.route) {
            InventoryScreen()
        }

        composable(Screen.Deliveries.route) {
            DeliveryListScreen()
        }
    }
}
