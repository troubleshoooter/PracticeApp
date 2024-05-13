package com.example.practiceapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(onClick: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { onClick() }) {
            Text(text = "Home Screen")
        }
    }
}