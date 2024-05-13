package com.example.practiceapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.practiceapp.ui.screens.detail.navigation.detailScreen
import com.example.practiceapp.ui.screens.detail.navigation.navigateToDetail
import com.example.practiceapp.ui.screens.home.navigation.HOME_ROUTE
import com.example.practiceapp.ui.screens.home.navigation.homeScreen
import com.example.practiceapp.ui.screens.home.navigation.navigateToHome
import com.example.practiceapp.ui.theme.PracticeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            PracticeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                }) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = HOME_ROUTE,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        homeScreen {
                            navController.navigateToDetail(
                                NavOptions.Builder().setPopUpTo(
                                    HOME_ROUTE, false
                                ).build()
                            )
                        }
                        detailScreen(onClick = {
                            navController.navigateToHome()
                        }, onSnackbar = { ->
                            snackbarHostState.showSnackbar(
                                message = "message",
                                actionLabel = "action",
                                duration = SnackbarDuration.Short,
                            ) == SnackbarResult.ActionPerformed
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeAppTheme {
        Greeting("Android")
    }
}