package com.example.ulpgcarapp.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ulpgcarapp.R
import com.example.ulpgcarapp.Screen

@Composable
fun SearchScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A donde quieres ir?",
                fontSize = 35.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var texto by remember { mutableStateOf("") }

            Button(
                onClick = {
                    texto = "Universidad"
                    navController.navigate(route = Screen.SearchOptionsScreen.passPlace(texto))
                     },
                modifier = Modifier
                    .height(80.dp)
                    .width(350.dp)
            ) {
                Text(
                    text = stringResource(R.string.texto_universidad),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.padding(32.dp))

            Button(
                onClick = {
                    texto = "Casa"
                    navController.navigate(route = Screen.SearchOptionsScreen.passPlace(texto))
                     },
                modifier = Modifier
                    .height(80.dp)
                    .width(350.dp)
            ) {
                Text(
                    text = stringResource(R.string.texto_casa),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}