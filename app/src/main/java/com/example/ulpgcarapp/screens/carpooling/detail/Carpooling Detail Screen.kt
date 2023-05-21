package com.example.ulpgcarapp.screens.carpooling.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun CarpoolingDetailScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {

        Text(
            text = "Carpooling Detail Screen",
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}