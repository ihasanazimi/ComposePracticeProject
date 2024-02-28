package com.example.composepracticeproject

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val CitiesList = mutableListOf("Tehran", "Alborz", "Tabriz", "Shiraz", "Mashhad")

val myTextStyle =
    TextStyle(fontSize = 18.sp, color = Color.White, shadow = Shadow(color = Color.Gray))

val listModifier = Modifier
    .fillMaxSize()
    .background(Color.DarkGray)
    .padding(10.dp)



@Composable
fun SimpleListView() {

    val itemExpanded = remember { mutableStateOf(false) }
//    val extraPadding = if (itemExpanded.value) 48.dp else 0.dp
    val extraPadding by animateDpAsState(
        if(itemExpanded.value) 48.dp else 0.dp, label = ""
    )

    LazyColumn(modifier = listModifier) {
        items(CitiesList) {
            Surface {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = extraPadding)) {

                    Divider()

                    Text(
                        text = it,
                        style = myTextStyle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(Color.Black)
                            .align(Alignment.CenterStart)
                            .padding(4.dp)
                    )


                    Button(
                        onClick = {
                            itemExpanded.value = !itemExpanded.value
                        },
                        border = BorderStroke(1.dp, Color.Black),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(vertical = 16.dp)
                    ) {
                        Text(if (itemExpanded.value) "Show Less" else "Show More")
                    }
                }
            }

        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun BasicsRowAndColumnPreview() {
    SimpleListView()

}