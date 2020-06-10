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
import com.example.playwithcompose.ui.BassAppState
import com.example.playwithcompose.ui.Screen

class MainActivity : AppCompatActivity() {

    private val state = BassAppState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content(state)
        }
    }

    override fun onBackPressed() {
        if (!state.navigateBack()) {
            super.onBackPressed()
        }
    }
}

@Composable
private fun content(state: BassAppState) {
    Crossfade(state.currentScreen) { screen ->
        AppScreen(
                when (screen) {
                    is Screen.BassList -> "All basses"
                    is Screen.BassDetail -> screen.bass.model
                },
                state
        ) {
            when (screen) {
                is Screen.BassList -> BassList(fakeBasses) {
                    state.navigateTo(Screen.BassDetail(it))
                }
                is Screen.BassDetail -> BassDetail(screen.bass)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    content(BassAppState())
}

val commonSpace = 16.dp

