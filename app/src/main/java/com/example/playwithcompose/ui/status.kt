package com.example.playwithcompose.ui

import android.net.Uri
import androidx.compose.Model
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import java.util.*
import kotlin.collections.ArrayList

sealed class Screen {
    object BassList : Screen()
    data class BassDetail(val bass: Bass) : Screen()
    object Cart : Screen()

    companion object {

        fun fromUri(uri: Uri): Screen? {
            if (uri.pathSegments.size == 2 && uri.pathSegments[0] == "detail") {
                val bassId = uri.pathSegments[1].toString()
                return fakeBasses.firstOrNull { it.id == bassId }?.let { BassDetail(it) }
            }

            return null
        }
    }
}

@Model
class BassAppState {
    val screens = LinkedList<Screen>().apply { push(Screen.BassList) }
    var cart = ArrayList<Bass>()
    var currentScreen: Screen = Screen.BassList
    var cartTotal: Float = 0f

    fun addToCart(bass: Bass) {
        cart = ArrayList(cart).apply { add(bass) }
        cartTotal = cart.map { it.price }.fold(0f) { acc, price -> acc + price }
    }

    fun removeFromCart(bass: Bass) {
        cart = ArrayList(cart).apply { remove(bass) }
        cartTotal = cart.map { it.price }.fold(0f) { acc, price -> acc + price }
    }

    fun navigateTo(destination: Screen) {
        if (currentScreen == destination) return

        currentScreen = destination
        screens.push(destination)
        canGoBack = true
    }

    fun navigateTo(uri: Uri) {
        Screen.fromUri(uri)?.let {
            navigateTo(it)
        }
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

