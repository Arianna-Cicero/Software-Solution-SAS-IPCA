package com.example.lojasocial_app.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Beneficiaries : Screen("beneficiaries")
    object Inventory : Screen("inventory")
    object Deliveries : Screen("deliveries")
}

