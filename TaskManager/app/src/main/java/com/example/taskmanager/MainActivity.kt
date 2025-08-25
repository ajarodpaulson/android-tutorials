package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskManagerApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp(innerPadding: PaddingValues) {
    TaskManagerCard(
        imgPainter = painterResource(R.drawable.ic_task_completed),
        taskStatusMsg = stringResource(R.string.all_tasks_completed),
        feedbackMsg = stringResource(R.string.nice_work),
        modifier = Modifier.padding(innerPadding)
    )
}

@Composable
fun TaskManagerCard(imgPainter: Painter,
                    taskStatusMsg: String,
                    feedbackMsg: String,
                    modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        Image(
            painter = imgPainter,
            contentDescription = null,
            modifier = modifier,
        )
        Text(
            text = taskStatusMsg,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                bottom = 8.dp,
                top = 24.dp),
        )
        Text(
            text = feedbackMsg,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerAppPreview() {
    TaskManagerTheme {
        TaskManagerApp(PaddingValues())
    }
}