package com.example.composepracticeproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


@Composable
@Preview(showSystemUi = true)
fun BasicsTextFieldsPreview() {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Sample Text",

            /* text style */
            style = TextStyle(
                color = Color.Red,
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W800,
                fontStyle = FontStyle.Italic, /* Italic OR Bold OR Normal*/
                letterSpacing = 0.5.em,
                background = Color.LightGray,
                textDecoration = TextDecoration.LineThrough, /* underline or line Through */
                /* shadow sample */
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5f,5f),
                    blurRadius = 5f
                )
            )
        )


        Text(modifier = Modifier.padding(vertical = 16.dp),
            text = "Test Text",
            /* text style */
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 24.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Normal, /* Italic OR Bold OR Normal*/
                background = Color.LightGray,
                textDecoration = TextDecoration.None, /* underline or line Through */
                /* shadow sample */
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(1f,1f),
                    blurRadius = 5f
                )
            )
        )


        Text(modifier = Modifier.padding(vertical = 16.dp),
            text = "Test Text",
            /* text style */
            style = MaterialTheme.typography.headlineLarge
        )



    }

}