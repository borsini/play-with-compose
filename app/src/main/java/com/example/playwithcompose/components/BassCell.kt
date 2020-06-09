package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.DensityAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.commonSpace
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.loadBitmap

@Composable
@Preview
fun BassCell(bass: Bass = fakeBasses.first()) {
    val typography = MaterialTheme.typography

    Row(modifier = Modifier.padding(commonSpace).fillMaxWidth()) {
        val imageSideLength = 70.dp
        val imageModifier = Modifier.preferredWidth(imageSideLength)
                .preferredHeight(imageSideLength)
                .clip(RoundedCornerShape(7.dp))

        val sideIpx = with(DensityAmbient.current) { imageSideLength.toIntPx() }

        loadBitmap(bass.imageUrl, sideIpx, sideIpx)?.let {
            Image(asset = it.asImageAsset(), modifier = imageModifier, contentScale = ContentScale.Crop)
        }

        Column(
                modifier = Modifier.fillMaxWidth().padding(start = commonSpace)
        ) {

            Text(bass.model, style = typography.body1)
            Text(bass.brand, style = typography.body1)
        }
    }
}
