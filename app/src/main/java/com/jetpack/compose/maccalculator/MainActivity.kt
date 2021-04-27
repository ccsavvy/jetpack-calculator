package com.jetpack.compose.maccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Column {
                        CalculatorTextField(Modifier.fillMaxWidth())
                        CalculatorFirstRow(Modifier.fillMaxWidth())
                        CalculatorSecondRow(Modifier.fillMaxWidth())
                        CalculatorThirdRow(Modifier.fillMaxWidth())
                        CalculatorFourthRow(Modifier.fillMaxWidth())
                        CalculatorLastRow(Modifier.fillMaxWidth())
                    }
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
fun CalculatorTextField(modifier: Modifier) {

    var textState by remember { mutableStateOf(TextFieldValue()) }
    Row(modifier = modifier) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = modifier
                .weight(1f)
                .height(100.dp)
                .background(textField)
                .wrapContentSize(Alignment.BottomEnd)
                .fillMaxHeight()
                .fillMaxWidth(),
            textStyle = TextStyle(fontSize = 24.sp, textAlign = TextAlign.End, color = textColor),
            placeholder = {
                ProvideTextStyle(TextStyle(color = textColor, textAlign = TextAlign.End)) {
                    Text(
                        text = "",
                        modifier = Modifier.wrapContentSize(Alignment.BottomEnd)
                    )
                }
            },
            maxLines = 2
        )
    }
}

@Composable
fun CalculatorFirstRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "AC")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "+/-")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "%")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "\u00F7")
        }
    }
}

@Composable
fun CalculatorSecondRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "7")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "8")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "9")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "*")
        }
    }
}

@Composable
fun CalculatorThirdRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "4")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "5")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "6")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "-")
        }
    }
}

@Composable
fun CalculatorFourthRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "1")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "2")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "3")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "+")
        }
    }
}

@Composable
fun CalculatorLastRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(2f),
            onClick = { /*TODO*/ }) {
            Text(text = "0")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = ".")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }) {
            Text(text = "=")
        }
    }
}

@Composable
fun CalculatorBox(shape: Shape) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(Color.Red)
        )
    }
}

class CalculatorBoxShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val rect = Rect(0f, 0f, 0f, 0f).apply { }
        return Outline.Rectangle(rect)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MacCalculatorTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            CalculatorTextField(Modifier.fillMaxWidth())
            CalculatorFirstRow(Modifier.fillMaxWidth())
            CalculatorSecondRow(Modifier.fillMaxWidth())
            CalculatorThirdRow(Modifier.fillMaxWidth())
            CalculatorFourthRow(Modifier.fillMaxWidth())
            CalculatorLastRow(Modifier.fillMaxWidth())
        }
    }
}