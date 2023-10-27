package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
		setContent {
			TaskManagerTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					TaskManagerApp()
				}
			}
		}
	}
}

@Composable
fun TaskManagerApp(){
	AppContent(
		message = stringResource(R.string.message),
		greeting = stringResource(R.string.greeting),
		image = painterResource(R.drawable.ic_task_completed)
	)
}
@Composable
private fun AppContent(
	message: String,
	greeting: String,
	image: Painter,
	modifier: Modifier = Modifier
) {
	Column (
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	){
		Image(
			painter = image,
			contentDescription = null
		)
		Text(
			text = message,
			modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
			fontWeight = FontWeight.Bold
		)
		Text(
			text = greeting,
			fontSize = 16.sp
		)
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	TaskManagerTheme {
		TaskManagerApp()
	}
}