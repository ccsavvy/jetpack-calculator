package com.jetpack.compose.maccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BaseTextField
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jetpack.compose.maccalculator.ui.MacCalculatorTheme
import com.jetpack.compose.maccalculator.ui.textColor
import com.jetpack.compose.maccalculator.ui.textField

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatorTextField() {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Column(with(ColumnScope) {
        Modifier.weight(1f)
    }
    ) {
        BaseTextField(
            textStyle = TextStyle(textAlign = TextAlign.End),
            textColor = textColor,
            cursorColor = textColor,
            value = textState,
            onValueChange = {
                textState = it
            },
            modifier = Modifier.background(textField)
                .height(100.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.BottomEnd)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MacCalculatorTheme {
        CalculatorTextField()
    }
}

//        Text(
//            text = textState.text,
//            modifier = Modifier.gravity(Alignment.End),
//            textAlign = TextAlign.End
//        )