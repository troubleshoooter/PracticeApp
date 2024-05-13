package com.example.practiceapp.ui.screens.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.practiceapp.ui.screens.detail.Detail

const val DETAIL_ROUTE = "detail_route"

fun NavController.navigateToDetail(navOptions: NavOptions) = navigate(DETAIL_ROUTE, navOptions)

fun NavGraphBuilder.detailScreen(
    onClick: () -> Unit,
    onSnackbar: suspend ()->Boolean
) {
    composable(route = DETAIL_ROUTE){
        Detail(onClick, onSnackbar)
    }
}