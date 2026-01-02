package com.example.lojasocial_app.core.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lojasocial_app.core.navigation.bottomNavItems

@Suppress("unused")
@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo("home") {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    // Render icon only when available to avoid NPE
                    screen.icon?.let { imageVector ->
                        Icon(
                            imageVector = imageVector,
                            contentDescription = screen.label
                        )
                    }
                },
                label = {
                    Text(screen.label)
                }
            )
        }
    }
}
