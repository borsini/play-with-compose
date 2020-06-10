package com.example.playwithcompose.components

import android.net.Uri
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
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import com.example.playwithcompose.commonSpace
import com.example.playwithcompose.fakeBasses
import com.example.playwithcompose.models.Bass
import com.example.playwithcompose.ui.loadBitmap

@Composable
fun BassDetail(bass: Bass = fakeBasses.first(), onLinkClicked: (Uri) -> Unit) {
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
        Button(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onLinkClicked(Uri.parse("https://bassapp.com/detail/4"))
                }) {
            Text("Click here to see our last model !")
        }

    }
}