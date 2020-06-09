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
object BassAppStatus {
    var currentScreen: Screen = Screen.BassList
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    BassAppStatus.currentScreen = destination
}