package com.example.playwithcompose.components

import android.content.Intent
import android.util.Log
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.ripple
import androidx.ui.tooling.preview.Preview
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.BassDetailActivity
import com.example.playwithcompose.ui.Screen
import com.example.playwithcompose.ui.navigateTo

@Preview
@Composable
fun BassList(basses: List<Bass> = fakeBasses) {
    AdapterList(data = basses) {
        Clickable(modifier = Modifier.ripple(),
                onClick = {
                    Log.d("onClickList", "clicked!")
                    navigateTo(
                        Screen.BassDetail(it)
                    )
                }) {
            BassCell(it)
        }
    }
}


