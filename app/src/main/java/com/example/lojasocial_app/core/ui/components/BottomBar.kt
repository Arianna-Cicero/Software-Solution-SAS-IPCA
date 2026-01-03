package com.example.lojasocial_app.core.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
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
    
    // IPCA Green color
    val ipcaGreen = Color(0xFF1B5E20)

    NavigationBar(
        containerColor = Color.White,
        contentColor = ipcaGreen
    ) {
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            // Pop até a home (startDestination)
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = screen.route == navController.graph.startDestinationRoute
                            }
                            // Evita múltiplas cópias da mesma tela
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    screen.icon?.let { imageVector ->
                        Icon(
                            imageVector = imageVector,
                            contentDescription = screen.label
                        )
                    }
                },
                label = {
                    Text(screen.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ipcaGreen,
                    selectedTextColor = ipcaGreen,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFFE8F5E9)
                )
            )
        }
    }
}
