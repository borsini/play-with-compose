package com.example.playwithcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.components.AppScreen
import com.example.playwithcompose.components.BassDetail
import com.example.playwithcompose.components.BassList
import com.example.playwithcompose.ui.BassAppStatus
import com.example.playwithcompose.ui.Screen
import com.example.playwithcompose.ui.navigateTo


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content()
        }
    }
}

@Composable
private fun content() {
    Crossfade(BassAppStatus.currentScreen) { screen ->
        AppScreen(
                when (screen) {
                    is Screen.BassList -> "BassList"
                    is Screen.BassDetail -> screen.bass.model
                }
        ) {
            when (screen) {
                is Screen.BassList -> BassList(fakeBasses) {
                    navigateTo(Screen.BassDetail(it))
                }
                is Screen.BassDetail -> BassDetail(screen.bass)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    content()
}

val commonSpace = 16.dp

