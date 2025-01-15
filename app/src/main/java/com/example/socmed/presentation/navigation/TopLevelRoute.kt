package com.example.socmed.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)
