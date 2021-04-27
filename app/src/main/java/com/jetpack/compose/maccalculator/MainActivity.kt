package com.jetpack.compose.maccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.compose.maccalculator.ui.MacCalculatorTheme
import com.jetpack.compose.maccalculator.ui.textColor
import com.jetpack.compose.maccalculator.ui.textField

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComposeView(this).also { setContentView(it) }.setContent {
            MacCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        CalculatorTextField(Modifier.fillMaxWidth())
                        CalculatorFirstRow(Modifier.fillMaxWidth())
                        CalculatorSecondRow(Modifier.weight(1f, true))
                        CalculatorThirdRow(Modifier.weight(1f, true))
                        CalculatorFourthRow(Modifier.weight(1f, true))
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

@ExperimentalFoundationApi
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
            }
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun CalculatorFirstRow(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(
            modifier = Modifier
                .clip(RectangleShape)
                .weight(1f)
                .background(Color(0xFF2C2F32)),
            onClick = { /*TODO*/ }) {
            Text(text = "AC")
        }
        Button(modifier = Modifier
            .clip(RectangleShape)
            .weight(1f)
            .background(Color(0xFF2C2F32)),
            onClick = { /*TODO*/ }) {
            Text(text = "+/-")
        }
        Button(modifier = Modifier
            .clip(RectangleShape)
            .weight(1f)
            .background(Color(0xFF2C2F32)),
            onClick = { /*TODO*/ }) {
            Text(text = "%")
        }
        Button(modifier = Modifier
            .clip(RectangleShape)
            .weight(1f)
            .background(Color(0xFF2C2F32)),
            onClick = { /*TODO*/ }) {
            Text(text = "\u00F7")
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CalculatorSecondRow(modifier: Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(4)) {
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "7")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "8")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "9")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "*")
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CalculatorThirdRow(modifier: Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(4)) {
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "4")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "5")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "6")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "-")
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CalculatorFourthRow(modifier: Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(4)) {
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "1")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "2")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "3")
                }
            }
        }
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
                    .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "+")
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MacCalculatorTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            CalculatorTextField(Modifier.fillMaxWidth())
            CalculatorFirstRow(Modifier.fillMaxWidth())
            CalculatorSecondRow(Modifier.weight(1f, true))
            CalculatorThirdRow(Modifier.weight(1f, true))
            CalculatorFourthRow(Modifier.weight(1f, true))
        }
    }
}