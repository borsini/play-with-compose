package com.example.playwithcompose.components

import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.material.ripple.ripple
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.BassAppState

@Composable
fun BassList(
    basses: List<Bass> = fakeBasses,
    state: BassAppState,
    onBassSelected: (Bass) -> Unit = {}
) {
    AdapterList(data = basses) {
        Clickable(modifier = Modifier.ripple(),
            onClick = {
                Log.d("onClickList", "clicked!")
                onBassSelected(it)
            }) {
            BassCell(it, state)
        }
    }
}


