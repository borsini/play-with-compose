package com.example.playwithcompose.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.Composable
import androidx.compose.onCommit
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.unit.IntPx
import coil.Coil
import coil.api.load
import coil.size.Scale


@Composable fun loadBitmap(
        url: String,
        width: IntPx,
        height: IntPx
): Bitmap? {
    val image = state<Bitmap?> { null }
    val context = ContextAmbient.current

    onCommit(url, width, height, context) {
        val requestDisposable = Coil.load(context, url) {
            size(width.value, height.value)
            scale(Scale.FIT)
            target(
                    onSuccess = { image.value = (it as? BitmapDrawable)?.bitmap },
                    onError = { image.value = null }
            )
        }

        onDispose { requestDisposable.dispose() }
    }

    return image.value
}