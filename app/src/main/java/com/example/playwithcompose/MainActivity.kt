package com.example.playwithcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.datasource.LoremIpsum
import androidx.ui.unit.dp
import com.example.playwithcompose.ui.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BassApp()
        }
    }
}

@Composable
fun BassApp() {
    AppTheme {
        Column {
            BassDetail()
        }
    }
}

@Composable
fun BassDetail() {
    val commonSpace = 16.dp
    val typography = MaterialTheme.typography

    Column(
            modifier = Modifier.padding(commonSpace)
    ) {

        SomethingWithCaption("La Tribe SF4 en action !") {
            val imageModifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(200.dp)
                    .clip(RoundedCornerShape(10.dp))
            Image(asset = imageResource(id = R.drawable.bass), modifier = imageModifier,
                    contentScale = ContentScale.Crop)
        }
        Spacer(Modifier.preferredHeight(commonSpace))
        Text("Tribe SF4", style = typography.h2)
        Text("Fretboard en érable", style = typography.h4)
        Spacer(Modifier.preferredHeight(commonSpace))
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

@Composable
fun SomethingWithCaption(title: String, content: @Composable() () -> Unit) {
    Column {
        content()
        Text(title, style = MaterialTheme.typography.caption)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BassApp()
}