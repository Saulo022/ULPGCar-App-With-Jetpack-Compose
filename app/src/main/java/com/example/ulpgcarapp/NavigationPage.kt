package com.example.ulpgcarapp

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import com.example.ulpgcarapp.screens.add_journey.AddJourneyScreen
import com.example.ulpgcarapp.screens.add_journey.detail.AddJourneyDetailScreen
import com.example.ulpgcarapp.screens.carpooling.CarpoolingScreen
import com.example.ulpgcarapp.screens.carpooling.detail.CarpoolingDetailScreen
import com.example.ulpgcarapp.screens.chat.ChatScreen
import com.example.ulpgcarapp.screens.profile.ProfileScreen
import com.example.ulpgcarapp.screens.profile.detail.ProfileDetailScreen
import com.example.ulpgcarapp.screens.search.SearchScreen
import com.example.ulpgcarapp.screens.search.choose_options.SearchOptionsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationPage() {

    val tabItems = listOf("Search", "Carpooling", "Add", "Chat", "Profile")

    var selectedItem = remember { mutableStateOf(0) }

    var navController = rememberNavController()

    val navBackStackEntry = navController.currentBackStackEntryAsState()

    val parentRouteName = navBackStackEntry.value?.destination?.parent?.route

    val routeName = navBackStackEntry.value?.destination?.route

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "$routeName") })
    }, bottomBar = {
        NavigationBar() {
            tabItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = parentRouteName == item,
                    onClick = {
                        selectedItem.value = index
                        navController.navigate(item, navOptions {

                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true

                        })
                    },
                    icon = {

                        when (item) {
                            "Search" -> Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                            "Carpooling" -> Icon(
                                imageVector = Icons.Default.DirectionsCar,
                                contentDescription = "Carpooling"
                            )
                            "Add" -> Icon(
                                imageVector = Icons.Default.AddBox,
                                contentDescription = "Add"
                            )
                            "Chat" -> Icon(
                                imageVector = Icons.Default.Chat,
                                contentDescription = "Chat"
                            )
                            "Profile" -> Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile"
                            )

                        }
                    },
                    label = { Text(text = item) })
            }
        }

    }) {
        Box(modifier = Modifier.padding(it)) {

            NavHost(navController = navController, startDestination = "Search") {

                navigation(startDestination = Screen.SearchScreen.route, route = "Search") {
                    composable(Screen.SearchScreen.route) {
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

                navigation(startDestination = Screen.CarpoolingScreen.route, route = "Carpooling") {
                    composable(Screen.CarpoolingScreen.route) {
                        CarpoolingScreen(navController = navController)
                    }
                    composable(Screen.CarpoolingDetailScreen.route) {
                        CarpoolingDetailScreen(navController = navController)
                    }
                }

                navigation(startDestination = Screen.AddJourneyScreen.route, route = "Add") {
                    composable(Screen.AddJourneyScreen.route) {
                        AddJourneyScreen(navController = navController)
                    }
                    composable(Screen.AddJourneyDetailScreen.route) {
                        AddJourneyDetailScreen(navController = navController)
                    }
                }

                navigation(startDestination = Screen.ChatScreen.route, route = "Chat") {
                    composable(Screen.ChatScreen.route) {
                        ChatScreen(navController = navController)
                    }
                }

                navigation(startDestination = Screen.ProfileScreen.route, route = "Profile") {
                    composable(Screen.ProfileScreen.route) {
                        ProfileScreen(navController = navController)
                    }
                    composable(Screen.ProfileDetailScreen.route) {
                        ProfileDetailScreen(navController = navController)
                    }
                }
            }
        }
    }
}