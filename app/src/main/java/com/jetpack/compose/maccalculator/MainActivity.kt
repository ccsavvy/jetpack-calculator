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
                        var op by remember { mutableStateOf("") }
                        var isNewOp by remember { mutableStateOf(true) }

                        var oldTextState: String by remember { mutableStateOf("") }
                        var textState: String by remember { mutableStateOf("") }

                        CalculatorTextField(
                            textState = textState,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { textState = it }
                        )
                        Column(modifier = Modifier.fillMaxSize()) {
                            CalculatorFirstRow(
                                isNewOp = isNewOp,
                                textState = textState,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                onOpChange = { op = it },
                                onOldValueChange = { oldTextState = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            CalculatorSecondRow(
                                isNewOp = isNewOp,
                                textState = textState,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                onOpChange = { op = it },
                                onOldValueChange = { oldTextState = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            CalculatorThirdRow(
                                isNewOp = isNewOp,
                                textState = textState,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                onOpChange = { op = it },
                                onOldValueChange = { oldTextState = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            CalculatorFourthRow(
                                isNewOp = isNewOp,
                                textState = textState,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                onOpChange = { op = it },
                                onOldValueChange = { oldTextState = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            CalculatorLastRow(
                                op = op,
                                oldNumber = oldTextState,
                                isNewOp = isNewOp,
                                textState = textState,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                        }
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
fun CalculatorTextField(
    textState: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit
) {
    Row(modifier = modifier) {
        TextField(
            value = textState,
            onValueChange = onValueChange,
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
            maxLines = 2,
            readOnly = true
        )
    }
}

@Composable
fun CalculatorFirstRow(
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                onValueChange.invoke("0")
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "AC")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("-$textState")
            }
        ) {
            Text(text = "+/-")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                val number = textState.toInt().div(100)
                onValueChange.invoke(number.toString())
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "%")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                onOpChange.invoke("/")
                onOldValueChange.invoke(textState)
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "\u00F7")
        }
    }
}

@Composable
fun CalculatorSecondRow(
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("7")
            }
        ) {
            Text(text = "7")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("8")
            }
        ) {
            Text(text = "8")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("9")
            }
        ) {
            Text(text = "9")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                onOpChange.invoke("*")
                onOldValueChange.invoke(textState)
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "*")
        }
    }
}

@Composable
fun CalculatorThirdRow(
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("4")
            }
        ) {
            Text(text = "4")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("5")
            }
        ) {
            Text(text = "5")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("6")
            }
        ) {
            Text(text = "6")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                onOpChange.invoke("-")
                onOldValueChange.invoke(textState)
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "-")
        }
    }
}

@Composable
fun CalculatorFourthRow(
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("1")
            }
        ) {
            Text(text = "1")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("2")
            }
        ) {
            Text(text = "2")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("3")
            }
        ) {
            Text(text = "3")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                onOpChange.invoke("+")
                onOldValueChange.invoke(textState)
                onIsNewOpChange.invoke(true)
            }
        ) {
            Text(text = "+")
        }
    }
}

@Composable
fun CalculatorLastRow(
    op: String,
    oldNumber: String,
    textState: String,
    isNewOp: Boolean,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(2f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                onValueChange.invoke("0")
            }
        ) {
            Text(text = "0")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (isNewOp) {
                    onValueChange.invoke("")
                }
                onIsNewOpChange.invoke(false)
                if (!textState.contains("."))
                    onValueChange.invoke(".")
            }
        ) {
            Text(text = ".")
        }
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            onClick = {
                if (oldNumber.isNotEmpty()) {
                    var finalNumber: Int? = null
                    when (op) {

                        "*" -> {
                            finalNumber = oldNumber.toInt() * textState.toInt()
                        }
                        "/" -> {
                            finalNumber = oldNumber.toInt() / textState.toInt()
                        }
                        "+" -> {
                            finalNumber = oldNumber.toInt() + textState.toInt()
                        }
                        "-" -> {
                            finalNumber = oldNumber.toInt() - textState.toInt()
                        }
                    }
                    onValueChange.invoke(finalNumber.toString())
                    onIsNewOpChange.invoke(true)
                }
            }
        ) {
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
        Column {
            var op by remember { mutableStateOf("") }
            var isNewOp by remember { mutableStateOf(true) }

            var oldTextState: String by remember { mutableStateOf("") }
            var textState: String by remember { mutableStateOf("") }

            CalculatorTextField(
                textState = textState,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { textState = it }
            )
            Column(modifier = Modifier.fillMaxSize()) {
                CalculatorFirstRow(
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    onOpChange = { op = it },
                    onOldValueChange = { oldTextState = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                CalculatorSecondRow(
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    onOpChange = { op = it },
                    onOldValueChange = { oldTextState = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                CalculatorThirdRow(
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    onOpChange = { op = it },
                    onOldValueChange = { oldTextState = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                CalculatorFourthRow(
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    onOpChange = { op = it },
                    onOldValueChange = { oldTextState = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                CalculatorLastRow(
                    op = op,
                    oldNumber = oldTextState,
                    isNewOp = isNewOp,
                    textState = textState,
                    onValueChange = { textState = it },
                    onIsNewOpChange = { isNewOp = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            }
        }
    }
}