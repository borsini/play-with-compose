package com.example.playwithcompose.ui

import androidx.compose.Model
import com.example.playwithcompose.models.Bass
import java.util.*

sealed class Screen {
    object BassList : Screen()
    data class BassDetail(val bass: Bass) : Screen()
}

@Model
class BassAppState {
    val screens = LinkedList<Screen>().apply { push(Screen.BassList) }

    var currentScreen: Screen = Screen.BassList

    fun navigateTo(destination: Screen) {
        if (currentScreen == destination) return

        currentScreen = destination
        screens.push(destination)
        canGoBack = true
    }

    fun navigateBack(): Boolean {
        return if (screens.size > 1) {
            screens.pop()
            currentScreen = screens.first
            canGoBack = screens.size > 1
            true
        } else false
    }

    var canGoBack: Boolean = false
}

