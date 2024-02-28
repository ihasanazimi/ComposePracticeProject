package com.example.composepracticeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun imageCard(painter: Painter , title : String , description : String) {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation()
    ) {

        Box(modifier = Modifier.height(200.dp)) {

            // cover
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = description ,
                contentScale = ContentScale.Crop
            )

            // black gradient
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ), startY = 400f
                        )
                    )
            )

            // text views container
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp, start = 8.dp, end = 8.dp),
                contentAlignment = Alignment.BottomStart
            ) {

                Text(
                    text = description,
                    style = TextStyle(
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontSize = 10.sp
                    )
                )
            }

        }
    }
}

@Composable
fun ImageCardSample(painter : Painter , title : String, description: String){
    imageCard(painter = painter , title = title , description = description )
}


@Preview(showBackground = true)
@Composable
private fun PewviewImagCard() {
    val painter = painterResource(id = R.drawable.profile)
    val title = stringResource(id = R.string.app_name)
    val description = "i am android developer and this is a sample card of basic components"
    imageCard(painter = painter , title = title , description = description )
}