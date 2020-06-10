package com.example.playwithcompose.ui

import androidx.compose.Model
import com.example.playwithcompose.models.Bass

/**
 * Class defining the screens we have in the app: home, article details and interests
 */
sealed class Screen {
    object BassList : Screen()
    data class BassDetail(val bass: Bass) : Screen()
}

@Model
class BassAppStatus {
    var currentScreen: Screen = Screen.BassList

    fun navigateTo(destination: Screen) {
        currentScreen = destination
    }
}

