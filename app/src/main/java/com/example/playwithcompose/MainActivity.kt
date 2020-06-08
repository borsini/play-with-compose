package com.example.playwithcompose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.ripple
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.playwithcompose.ui.AppTheme
import com.example.playwithcompose.ui.loadBitmap


data class Bass(
        val imageUrl: String, val imageCaption: String,
        val title: String, val subtitle: String, val body: String
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BassList(basses)
        }
    }
}

val commonSpace = 16.dp

@Composable
fun BassList(basses: List<Bass>) {
    val scaffoldState = remember { ScaffoldState() }
    Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = { Text("Drawer content") },
            topAppBar = {
                TopAppBar(
                        title = { Text("BassList") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scaffoldState.drawerState = DrawerState.Opened
                            }) {
                                Icon(Icons.Filled.Menu)
                            }
                        }
                )
            },
            bodyContent = {
                AdapterList(data = basses) {
                    Clickable(modifier = Modifier.ripple(),
                              onClick = { Log.d("onClickList", "clicked!") }) {
                        BassCell(it)
                    }
                }
            }
    )
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
@Preview
fun BassCell(bass: Bass = basses.first()) {
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

            Text(bass.title, style = typography.body1)
            Text(bass.subtitle, style = typography.body1)
        }
    }
}

@Composable
fun BassDetail() {
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