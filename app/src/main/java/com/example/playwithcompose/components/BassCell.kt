package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.DensityAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Delete
import androidx.ui.material.icons.filled.ShoppingCart
import androidx.ui.unit.dp
import com.example.playwithcompose.commonSpace
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.BassAppState
import com.example.playwithcompose.ui.loadBitmap
import com.example.playwithcompose.ui.purple500

@Composable
fun BassCell(bass: Bass = fakeBasses.first(), state: BassAppState) {
    val typography = MaterialTheme.typography

    Row(modifier = Modifier.padding(commonSpace).fillMaxWidth()) {
        val imageSideLength = 70.dp
        val imageModifier = Modifier.preferredWidth(imageSideLength)
            .preferredHeight(imageSideLength)
            .clip(RoundedCornerShape(7.dp))

        val sideIpx = with(DensityAmbient.current) { imageSideLength.toIntPx() }

        loadBitmap(bass.imageUrl, sideIpx, sideIpx)?.let {
            Image(
                asset = it.asImageAsset(),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        }

        Box(Modifier.weight(1f)) {
            Column(
                modifier = Modifier.padding(start = commonSpace)
            ) {

                Text(bass.model, style = typography.body1)
                Text(bass.brand, style = typography.body1)
                Text("${bass.price} €", style = typography.body2)
            }
        }

        val isInCart = state.cart.contains(bass)

        IconButton(onClick = {
            if (isInCart) {
                state.removeFromCart(bass)
            } else {
                state.addToCart(bass)
            }
        }) {
            if (isInCart) {
                Icon(Icons.Filled.Delete, tint = purple500)
            } else {
                Icon(Icons.Filled.ShoppingCart, tint = purple500)
            }
        }
    }
}