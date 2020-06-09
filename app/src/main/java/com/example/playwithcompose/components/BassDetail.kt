package com.example.playwithcompose.components

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.R
import com.example.playwithcompose.commonSpace

@Preview
@Composable
fun BassDetail() {
    val typography = MaterialTheme.typography

    Column(
            modifier = Modifier.padding(commonSpace)
    ) {
        val imageModifier = Modifier
                .fillMaxWidth()
                .preferredHeight(200.dp)
                .clip(RoundedCornerShape(10.dp))
        Image(asset = imageResource(id = R.drawable.bass), modifier = imageModifier,
                contentScale = ContentScale.Crop)

        Spacer(Modifier.preferredHeight(commonSpace))
        Text("Tribe SF4", style = typography.h2)
        Text("Fretboard en érable", style = typography.h4)
        Divider(color = Color.Black)
        Text(
                """
                    Née en 2016, la SF a été immédiatement testée sur la scène du stade Meazza.
                    Passive, petite, légère avec une telle polyvalence, la SF est une basse professionnelle, pour tout jouer, grâce à la configuration des micros qui permet d'avoir 7 combinaisons différentes.

                    Sa conception s'inspire de la célèbre Fender Aerodyne Jazz Bass.
                """.trimIndent(),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = typography.body1)

    }
}