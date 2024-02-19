package com.example.composepracticeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepracticeproject.ui.theme.ComposePracticeProjectTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePracticeProjectTheme {
//                Profile()
//                Parent()
                ImageCardSample(
                    painter = painterResource(id = R.drawable.profile),
                    title = "Hasan azimi",
                    description = "iam the android developer at ebcom or mci company"
                )
            }
        }

    }


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        ComposePracticeProjectTheme {
//            Profile()
//            Parent()
            ImageCardSample(
                painter = painterResource(id = R.drawable.profile),
                title = "Hasan azimi",
                description = "iam the android developer at ebcom or mci company"
            )
        }
    }

}


