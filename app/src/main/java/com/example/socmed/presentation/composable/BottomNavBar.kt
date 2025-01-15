package com.example.socmed.presentation.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.socmed.presentation.navigation.TopLevelRoute


@Composable
fun BottomNavBar(navController: NavController, topLevelRoutes: List<TopLevelRoute<out Any>>) {
    BottomNavigation(backgroundColor = BottomAppBarDefaults.bottomAppBarFabColor) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        topLevelRoutes.forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(destination.route::class) } == true,
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.name
                    )
                },
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}