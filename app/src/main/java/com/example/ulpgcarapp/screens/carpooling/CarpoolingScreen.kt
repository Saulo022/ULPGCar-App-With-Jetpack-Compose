package com.example.ulpgcarapp.screens.carpooling

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.ulpgcarapp.Screen

@Composable
fun CarpoolingScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Carpooling Screen")
            
            Button(onClick = { navController.navigate(Screen.CarpoolingDetailScreen.route) }) {
                
                Text(text = "Carpooling Screen Detail")
            }
        }
    }
}