package com.example.playwithcompose.components

import android.util.Log
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.ripple
import com.example.playwithcompose.ui.AppTheme
import com.example.playwithcompose.ui.Screen

@Composable
fun AppScreen(
    screenTitle: String,
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
                                IconButton(onClick = {
                                    scaffoldState.drawerState = DrawerState.Opened
                                }) {
                                    Icon(Icons.Filled.Menu)
                                }
                            }
                    )
                },
                bodyContent =  { bodyContent() }
        )
    }
}