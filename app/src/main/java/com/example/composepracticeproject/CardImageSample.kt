package com.example.composepracticeproject

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.util.Date

@Composable
fun Parent() {

    var date = Date()
    var temp = Temp(date)
    var counter by remember {
        mutableStateOf(0)
    }

    Surface {
        Button(onClick = { counter++ }) {
            Text(text = counter.toString())
            if (counter == 3) temp = Temp(Date())
            Child(temp = temp,"")
        }
    }

}

@Composable
fun Child(temp: Temp , string: String) {
    Text(text = temp.toString())
}


@Stable
data class Temp( val date: Date,val s : Int=0)