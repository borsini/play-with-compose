package com.example.playwithcompose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.material.ripple.ripple
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.components.BassApp
import com.example.playwithcompose.components.BassCell
import com.example.playwithcompose.components.BassList


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
    BassApp {
        BassList(fakeBasses)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    content()
}

val commonSpace = 16.dp

