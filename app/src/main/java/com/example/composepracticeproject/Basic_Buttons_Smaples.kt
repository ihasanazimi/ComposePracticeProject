package com.example.composepracticeproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true)
fun BasicsButtonsPreview() {

    // Buttons
    Column(modifier = Modifier.padding(16.dp)) {


        // simple btn
        Button(onClick = { /* todo */ }) {
            Text(text = "Simple Button")
        }


        // costume color button
        Button(
            onClick = {/* todo */ },
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(text = "Button with gray background", color = Color.White)
        }



        // Button with multiple text
        Button(onClick = {/* todo */ }, colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Click ", color = Color.Black)
            Text(text = "Here", color = Color.Yellow)
        }



        // Button with Icon
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            // todo : use another concept - for ex : Icon()
            Image(
                painter = painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = "cart button icon",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "button with icon",
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }


        // Cut Corner Shape
        Button(onClick = {}, shape = CutCornerShape(35)) {
            Text(text = "Cut corner shape")
        }



        Button(
            onClick = { /* your onclick code */ },
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "Button with border", color = Color.DarkGray)
        }



        // Elevated Button Elevation
        Button(colors = ButtonDefaults.buttonColors(Color.Blue) ,onClick = {
            //your onclick code here
        },elevation =  ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
            Text(text = "Button with elevation")
        }


    }


}