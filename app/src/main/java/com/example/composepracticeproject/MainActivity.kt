package com.example.composepracticeproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepracticeproject.ui.theme.ComposePracticeProjectTheme
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePracticeProjectTheme {
                Profile()
            }
        }

    }


    @Composable
    fun MainScreen() {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Center,
                modifier = Modifier.wrapContentHeight()
            ) {

            }
        }
    }


    @Composable
    fun GenerateButton(text: String = "", tag: String = "", onClickListener: () -> Unit) {
        Button(
            onClick = { onClickListener.invoke() },
            modifier = Modifier
                .testTag(tag)
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(all = 8.dp)
                .clickable { }
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }


    @Composable
    fun GenerateText(text: String = "", tag: String = "", onClickListener: () -> Unit) {
        Text(
            text = text,
            modifier = Modifier
                .testTag(tag)
                .padding(all = 8.dp)
                .clickable { onClickListener.invoke() }
                .wrapContentWidth()
                .wrapContentHeight()
        )
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposePracticeProjectTheme {
            MainScreen()
        }
    }

}


