package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box {
        MainScreenBackground(modifier)
        TappableImageAndLabel(modifier)
    }

}

@Composable
fun TappableImageAndLabel(modifier: Modifier) {
    var state by remember { mutableIntStateOf(1) }
    var numberLemonSqueezeTapsRequired by remember { mutableIntStateOf(0) }
    var numberLemonSqueezeTapsAchieved by remember { mutableIntStateOf(0) }

    val imageResource = when (state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescription = when (state) {
        1 -> "Lemon tree"
        2 -> "Lemon squeeze"
        3 -> "Lemon drink"
        else -> "Lemon restart"
    }

    val imageLabel = when (state) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemonade_drink
        else -> R.string.lemon_restart
    }

    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(imageResource),
            contentDescription = "Lemon Tree",
            Modifier.clickable(
                onClick = {
                    if (state == 1) {
                        numberLemonSqueezeTapsRequired = (2..4).random()
                        state++
                    } else if (state == 2) {
                        numberLemonSqueezeTapsAchieved++

                        if (numberLemonSqueezeTapsAchieved < numberLemonSqueezeTapsRequired) {
                            numberLemonSqueezeTapsAchieved++
                        } else {
                            numberLemonSqueezeTapsAchieved = 0
                            state++
                        }
                    } else if (state == 3) {
                        state++
                    } else {
                        state = 1
                    }
                }
            )

        )
        Text(
            text = stringResource(imageLabel)
        )
    }
}

@Composable
fun MainScreenBackground(modifier: Modifier) {
    Column(
        modifier.fillMaxSize()
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Lemonade",
                style = MaterialTheme.typography.titleLarge,

                )
        }
        Column(modifier.weight(9f)) {

        }
    }
}