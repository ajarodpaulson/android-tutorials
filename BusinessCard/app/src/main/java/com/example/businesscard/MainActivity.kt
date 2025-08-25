package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier
                .weight(3f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(1f)
                    .background(Color.DarkGray)
            )
            Text(
                text = "Jarod Paulson",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
            )

            Text(
                text = "Android Developer Extraordinaire",
                style = MaterialTheme.typography.labelLarge,
                color = Color.DarkGray,
                modifier = Modifier,
            )
        }

        ContactCard(
            "(416) 576-3312",
            "linkedin.com/in/jarodpaulson",
            "ajarodpaulson.ubc@gmail.com",
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp)
        )

    }
}

@Composable
fun ContactCard(phoneNumber: String, website: String, email: String, modifier: Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painterResource(R.drawable.baseline_local_phone_24),
                contentDescription = "Phone number"
            )
            Text(
                text = phoneNumber
            )
        }
        Row {
            Image(
                painterResource(R.drawable.share),
                contentDescription = "Share"
            )
            Text(
                text = website
            )
        }
        Row {
            Image(
                painterResource(R.drawable.mail),
                contentDescription = "Mail"
            )
            Text(
                text = email
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp(Modifier.fillMaxSize())
    }
}