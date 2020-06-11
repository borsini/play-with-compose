package com.example.playwithcompose.components

import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
import com.example.playwithcompose.commonSpace
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.BassAppState

@Composable
fun Cart(state: BassAppState, onBassSelected: (Bass) -> Unit = {}) {
    Column {
        Box(Modifier.weight(1f)) {
            AdapterList(data = state.cart) {
                Clickable(modifier = Modifier.ripple(),
                    onClick = {
                        Log.d("onClickList", "clicked!")
                        onBassSelected(it)
                    }) {
                    BassCell(it, state)
                }
            }
        }
        Box(Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.fillMaxWidth().padding(commonSpace),
                backgroundColor = MaterialTheme.colors.primaryVariant,
                onClick = {}) {
                Text(text = "Proceed with payment - ${state.cartTotal} €")
            }
        }
    }

}


