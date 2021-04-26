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
                        CalculatorTextField()
                        CalculatorFirstRow(Modifier.weight(1f, true))
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
fun CalculatorTextField() {

    var textState by remember { mutableStateOf(TextFieldValue()) }
    Row {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier
                .background(textField)
                .height(100.dp)
                .weight(1f, false)
                .fillMaxWidth()
                .wrapContentSize(Alignment.BottomEnd),
            textStyle = TextStyle(textAlign = TextAlign.End, color = textColor),
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
    LazyVerticalGrid(cells = GridCells.Fixed(4)) {
        items(1) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    modifier = Modifier
                        .clip(RectangleShape)
                        .fillMaxSize()
                        .background(Color(0xFF2C2F32)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "AC")
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
                    Text(text = "+/-")
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
                    Text(text = "%")
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
                    Text(text = "\u00F7")
                }
            }
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
        Column {
            CalculatorTextField()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, true)
            )
            {
                CalculatorFirstRow(Modifier.weight(1f, true))
                CalculatorSecondRow(Modifier.weight(1f, true))
                CalculatorThirdRow(Modifier.weight(1f, true))
                CalculatorFourthRow(Modifier.weight(1f, true))
            }
        }
    }
}