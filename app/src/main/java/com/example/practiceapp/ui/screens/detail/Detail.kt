package com.example.practiceapp.ui.screens.detail

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun Detail(onClick: () -> Unit, onSnackbar: suspend () -> Boolean) {
    LaunchedEffect(key1 = onSnackbar) {
        onSnackbar()
    }
    Button(onClick = {
        onClick()
    }) {
        Text(text = "Detail Screen")
    }
}