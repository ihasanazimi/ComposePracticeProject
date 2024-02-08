package com.example.composepracticeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedInputTextField(
    hint: String,
    keyboardOption: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    defaultValue: String = ""
) {
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
fun MyCaptionTextFiled(caption: String = "", modifier: Modifier = Modifier) {
    Text(
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        fontWeight = FontWeight.Thin,
        text = caption,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}


@Composable
fun MyPrimaryButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit
) {
    ElevatedButton(
        modifier = modifier,
        onClick = { onClickListener.invoke() }) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = buttonText
        )
    }
}


@Composable
fun MyTitleTextFiled(title: String = "", modifier: Modifier = Modifier) {
    Text(
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        text = title,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}


@Composable
fun MyHeader(title : String = "", leftIcon : Painter?= null, rightIcon : Painter?= null ) {
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
            painter = leftIcon?: painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = null
        )

        Text(
            fontStyle = FontStyle.Normal,
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            text = title,
            modifier = Modifier.align(
                Alignment.Center
            )
        )

        Image(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd),
            painter = rightIcon?: painterResource(id = R.drawable.baseline_settings_24),
            contentDescription = null
        )
    }
}


@Composable
fun CircularImage(src : Painter , modifier: Modifier = Modifier){
    Image(
        painter = src,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

