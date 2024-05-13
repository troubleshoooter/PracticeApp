package com.example.practiceapp.ui.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.practiceapp.ui.screens.home.Home

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome() = navigate(HOME_ROUTE)

fun NavGraphBuilder.homeScreen(
    onClick: () -> Unit
) {
    composable(route = HOME_ROUTE) {
        Home(onClick)
    }
}