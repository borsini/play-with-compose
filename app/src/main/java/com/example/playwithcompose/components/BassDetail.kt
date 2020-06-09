package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.DensityAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.R
import com.example.playwithcompose.commonSpace
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.loadBitmap

@Preview
@Composable
fun BassDetail(bass: Bass = fakeBasses.first()) {
    val typography = MaterialTheme.typography

    Column(
            modifier = Modifier.padding(commonSpace)
    ) {
        val imageHeight = 200.dp
        val imageWidth = 600.dp
        val imageModifier = Modifier
                .fillMaxWidth()
                .preferredHeight(imageHeight)
                .clip(RoundedCornerShape(10.dp))
        val heightIpx = with(DensityAmbient.current) { imageHeight.toIntPx() }
        val widthIpx = with(DensityAmbient.current) { imageWidth.toIntPx() }

        loadBitmap(bass.imageUrl, widthIpx, heightIpx)?.let {
            Image(asset = it.asImageAsset(), modifier = imageModifier, contentScale = ContentScale.Crop)
        }
        Spacer(Modifier.preferredHeight(commonSpace))
        Text(bass.model, style = typography.h2)
        Text(bass.brand, style = typography.h4)
        Divider(color = Color.Black)
        Text(bass.description.trimIndent(),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = typography.body1)

    }
}