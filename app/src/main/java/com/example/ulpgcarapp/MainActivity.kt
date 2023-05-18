package com.example.ulpgcarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ulpgcarapp.common.components.DatePickerComposable
import com.example.ulpgcarapp.screens.search.SearchScreen
import com.example.ulpgcarapp.screens.search.SearchViewModel
import com.example.ulpgcarapp.screens.search.choose_options.SearchOptionsScreen
import com.example.ulpgcarapp.ui.theme.ULPGCarAppTheme

class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ULPGCarAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}