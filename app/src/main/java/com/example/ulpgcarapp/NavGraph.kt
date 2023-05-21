package com.example.ulpgcarapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ulpgcarapp.screens.search.SearchScreen
import com.example.ulpgcarapp.screens.search.choose_options.SearchOptionsScreen

//@Composable
/*fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SearchScreen.route
    ) {
        composable(
            route = Screen.SearchScreen.route
        ) {
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.SearchOptionsScreen.route,
            arguments = listOf(navArgument(SEARCH_OPTION_SCREEN_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ) {
            Log.d("Args", it.arguments?.getString(SEARCH_OPTION_SCREEN_ARGUMENT_KEY).toString())
            SearchOptionsScreen(it.arguments?.getString(SEARCH_OPTION_SCREEN_ARGUMENT_KEY).toString())
        }
    }
}

 */