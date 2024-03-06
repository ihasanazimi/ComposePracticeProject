package com.example.composepracticeproject

import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Stable
data class CityEntity(val name: String, var expanded: Boolean = false)

val myTextStyle =
    TextStyle(
        fontSize = 18.sp,
        color = Color.White,
        shadow = Shadow(color = Color.Gray)
    )

val listModifier = Modifier
    .fillMaxSize()
    .background(Color.DarkGray)
    .padding(10.dp)


@Composable
fun SimpleListView() {


    var myList by remember {
        mutableStateOf<List<CityEntity>>(
            arrayListOf(
                CityEntity("Tehran", false),
                CityEntity("Alborz", false),
                CityEntity("Tabriz", false),
                CityEntity("Shiraz", false),
                CityEntity("Mashhad", false),
            )
        )
    }

//    val itemExpanded = remember { mutableStateOf(false) }
//
////  todo  val extraPadding = if (itemExpanded.value) 48.dp else 0.dp'
//
//    val extraPadding by animateDpAsState(
//        if(itemExpanded.value) 48.dp else 0.dp, label = ""
//    )

    LazyColumn(modifier = listModifier) {
        items(myList) { city ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = if (city.expanded) 48.dp else 0.dp)
            ) {

                Text(
                    text = city.name,
                    style = myTextStyle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(if (city.expanded) Color.Black else Color.Red)
                        .align(Alignment.CenterStart)
                        .padding(4.dp)
                )

                Button(
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(vertical = 16.dp),
                    onClick = {
                        Log.i("hasan", "obj: ${city}")
                        city.expanded = city.expanded.not()
                    }) {
                    Text(if (city.expanded) "Less" else "More")
                }
                Divider()
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun BasicsRowAndColumnPreview() {
    SimpleListView()
}