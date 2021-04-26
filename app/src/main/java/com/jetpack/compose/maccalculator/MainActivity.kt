package com.jetpack.compose.maccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.maccalculator.ui.MacCalculatorTheme
import com.jetpack.compose.maccalculator.ui.textColor
import com.jetpack.compose.maccalculator.ui.textField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComposeView(this).also { setContentView(it) }.setContent {
            MacCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CalculatorTextField()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CalculatorTextField() {

    var textState by remember { mutableStateOf(TextFieldValue()) }
    Column {
        ProvideTextStyle(TextStyle(color = textColor)) {
            TextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier
                    .background(textField)
                    .height(100.dp)
                    .weight(1f, false)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomEnd),
                textStyle = TextStyle(textAlign = TextAlign.End, color = textColor)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MacCalculatorTheme {
        CalculatorTextField()
    }
}