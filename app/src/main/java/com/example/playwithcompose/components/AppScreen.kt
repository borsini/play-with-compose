package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.material.icons.filled.Home
import androidx.ui.material.icons.filled.Settings
import androidx.ui.material.icons.filled.ShoppingCart
import com.example.playwithcompose.ui.AppTheme
import com.example.playwithcompose.ui.BassAppState
import com.example.playwithcompose.ui.Screen

@Composable
fun AppScreen(
        screenTitle: String,
        state: BassAppState,
        bodyContent: @Composable() () -> Unit
) {
    AppTheme {
        val scaffoldState = remember { ScaffoldState() }
        Scaffold(
                scaffoldState = scaffoldState,
                topAppBar = {
                    TopAppBar(
                            title = { Text(screenTitle) },
                            navigationIcon = {
                                if (state.canGoBack) {
                                    IconButton(onClick = { state.navigateBack() }) {
                                        Icon(Icons.Filled.ArrowBack)
                                    }
                                }
                            }
                    )
                },
                bodyContent = {
                    Column {
                        Box(Modifier.weight(1f)) {
                            bodyContent()
                        }
                        Box {
                            BottomNavigation {
                                BottomNavigationItem(
                                        icon = { Icon(Icons.Filled.Home) },
                                        text = { Text("All basses") },
                                        selected = state.currentScreen == Screen.BassList,
                                        onSelected = { state.navigateTo(Screen.BassList) }
                                )
                                BottomNavigationItem(
                                        icon = { Icon(Icons.Filled.ShoppingCart) },
                                        text = { Text("My cart") },
                                        selected = false,
                                        onSelected = {}
                                )
                                BottomNavigationItem(
                                        icon = { Icon(Icons.Filled.Settings) },
                                        text = { Text("Settings") },
                                        selected = false,
                                        onSelected = {}
                                )
                            }
                        }
                    }
                }
        )
    }
}