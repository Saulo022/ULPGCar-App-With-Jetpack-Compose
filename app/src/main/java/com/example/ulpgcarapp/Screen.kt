package com.example.ulpgcarapp

const val SEARCH_OPTION_SCREEN_ARGUMENT_KEY = "place"

sealed class Screen(val route: String) {
    object SearchScreen : Screen(route = "search_screen")
    object SearchOptionsScreen :
        Screen(route = "search_options_screen/{$SEARCH_OPTION_SCREEN_ARGUMENT_KEY}") {
        fun passPlace(place: String): String {
            return this.route.replace(
                oldValue = "{$SEARCH_OPTION_SCREEN_ARGUMENT_KEY}",
                newValue = place
            )
        }
    }
}
