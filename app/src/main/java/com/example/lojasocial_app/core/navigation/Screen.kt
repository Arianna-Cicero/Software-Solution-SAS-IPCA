@file:Suppress("DEPRECATION")
package com.example.lojasocial_app.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Send
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val label: String,
    val icon: ImageVector? = null
) {
    object Login : Screen("login", "Login")

    object Home : Screen(
        route = "home",
        label = "Home",
        icon = Icons.Default.Home
    )

    object Beneficiaries : Screen(
        route = "beneficiaries",
        label = "Beneficiários",
        icon = Icons.Default.Person
    )

    object Inventory : Screen(
        route = "inventory",
        label = "Inventário",
        icon = Icons.Default.ShoppingCart
    )

    object Deliveries : Screen(
        route = "deliveries",
        label = "Entregas",
        icon = Icons.Default.Send
    )
}
