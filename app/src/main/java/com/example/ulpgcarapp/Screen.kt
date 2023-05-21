package com.example.ulpgcarapp

const val SEARCH_OPTION_SCREEN_ARGUMENT_KEY = "place"

sealed class Screen(val route: String) {
    object SearchScreen : Screen(route = "Buscar viaje")
    object SearchOptionsScreen :
        Screen(route = "search_options_screen/{$SEARCH_OPTION_SCREEN_ARGUMENT_KEY}") {
        fun passPlace(place: String): String {
            return this.route.replace(
                oldValue = "{$SEARCH_OPTION_SCREEN_ARGUMENT_KEY}",
                newValue = place
            )
        }
    }

    object CarpoolingScreen : Screen(route = "carpooling_screen")

    object CarpoolingDetailScreen : Screen(route = "carpooling_detail_screen")

    object AddJourneyScreen : Screen(route = "add_journey_screen")

    object AddJourneyDetailScreen : Screen(route = "add_journey_detail_screen")

    object ChatScreen : Screen(route = "chat_screen")

    object ProfileScreen : Screen(route = "profile_screen")

    object ProfileDetailScreen : Screen(route = "profile_detail_screen")
}
