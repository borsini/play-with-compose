package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import com.example.playwithcompose.ui.AppTheme
import com.example.playwithcompose.ui.BassAppState

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
                bodyContent = { bodyContent() }
        )
    }
}