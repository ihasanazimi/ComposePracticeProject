@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composepracticeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Profile() {

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state)
    ) {

        Header()

        Spacer(modifier = Modifier.padding(0.dp, 8.dp))

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, Color.LightGray, CircleShape)
        )

        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        TitleTextFiled("Hasan Azimi")
        CaptionTextFiled("@ihasanazimi")


        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        MyOutlinedTextField("YourEmail", KeyboardOptions(keyboardType = KeyboardType.Email))
        MyOutlinedTextField("Phone Number", KeyboardOptions(keyboardType = KeyboardType.Phone))
        MyOutlinedTextField("Postal Code", KeyboardOptions(keyboardType = KeyboardType.Number))
        MyOutlinedTextField("Password", KeyboardOptions(keyboardType = KeyboardType.NumberPassword))
        PrimaryButton("Submit") {
            // todo
        }


    }

}


@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart),
            alignment = Alignment.CenterStart,
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = null
        )

        Text(
            fontStyle = FontStyle.Normal,
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            text = "Profile",
            modifier = Modifier.align(
                Alignment.Center
            )
        )

        Image(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.baseline_settings_24),
            contentDescription = null
        )
    }
}


@Composable
fun TitleTextFiled(title: String = "") {
    Text(
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        text = title,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun CaptionTextFiled(caption: String = "") {
    Text(
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        fontWeight = FontWeight.Thin,
        text = caption,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
}


@Composable
fun MyOutlinedTextField(hint: String, keyboardOption: KeyboardOptions, defaultValue: String = "") {
    var text by remember { mutableStateOf(defaultValue) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp),
        value = text,
        keyboardOptions = keyboardOption,
        onValueChange = { text = it },
        label = { Text(hint) }
    )
}


@Composable
fun PrimaryButton(buttonText: String, onClickListener: () -> Unit) {
    ElevatedButton(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .height(48.dp),
        onClick = { onClickListener.invoke() }) {
        Text(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = buttonText
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Profile()
}