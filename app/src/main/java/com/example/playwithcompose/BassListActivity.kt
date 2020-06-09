package com.example.playwithcompose

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.ripple.ripple
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.components.BassApp
import com.example.playwithcompose.components.BassCell
import com.example.playwithcompose.components.BassDetail
import com.example.playwithcompose.components.BassList
import com.example.playwithcompose.ui.BassAppStatus
import com.example.playwithcompose.ui.Screen


class BassListActivity : AppCompatActivity() {
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
        BassApp {
            when (screen) {
                is Screen.BassList -> BassList(fakeBasses)
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

