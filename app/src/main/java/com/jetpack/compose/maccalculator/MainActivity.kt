package com.jetpack.compose.maccalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                        var textState: String by remember { mutableStateOf("0") }

                        CalculatorTextField(
                            textState = textState,
                            modifier = Modifier.height(100.dp),
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
    Column(
        modifier = modifier
            .background(textField)
            .wrapContentSize(Alignment.BottomEnd)
            .fillMaxSize()
    ) {
        TextField(
            value = textState,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.BottomEnd)
                .fillMaxSize(),
            textStyle = TextStyle(fontSize = 36.sp, textAlign = TextAlign.End, color = textColor),
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
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF404345))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            onValueChange.invoke("0")
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "AC",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF404345))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var plusOrMinus = textState
                            if (isNewOp) {
                                plusOrMinus = ""
                                onValueChange.invoke(plusOrMinus)
                            }
                            onIsNewOpChange.invoke(false)

                            plusOrMinus = "-$plusOrMinus"
                            onValueChange.invoke(plusOrMinus)
                        }
                    )
            ) {
                Text(
                    text = "+/-",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF404345))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            val number = textState
                                .toInt()
                                .div(100)
                            onValueChange.invoke(number.toString())
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "%",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFFFD9E2B))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            onOpChange.invoke("/")
                            onOldValueChange.invoke(textState)
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "\u00F7",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
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
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var seven = textState
                            if (isNewOp) {
                                seven = ""
                                onValueChange.invoke(seven)
                            }
                            onIsNewOpChange.invoke(false)

                            seven += "7"
                            onValueChange.invoke(seven)
                        }
                    )
            ) {
                Text(
                    text = "7",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var eight = textState
                            if (isNewOp) {
                                eight = ""
                                onValueChange.invoke(eight)
                            }
                            onIsNewOpChange.invoke(false)

                            eight += "8"
                            onValueChange.invoke(eight)
                        }
                    )
            ) {
                Text(
                    text = "8",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var nine = textState
                            if (isNewOp) {
                                nine = ""
                                onValueChange.invoke(nine)
                            }
                            onIsNewOpChange.invoke(false)

                            nine += "9"
                            onValueChange.invoke(nine)
                        }
                    )
            ) {
                Text(
                    text = "9",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFFFD9E2B))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            onOpChange.invoke("*")
                            onOldValueChange.invoke(textState)
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "*",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
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
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var four = textState
                            if (isNewOp) {
                                four = ""
                                onValueChange.invoke(four)
                            }
                            onIsNewOpChange.invoke(false)

                            four += "4"
                            onValueChange.invoke(four)
                        }
                    )
            ) {
                Text(
                    text = "4",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var five = textState
                            if (isNewOp) {
                                five = ""
                                onValueChange.invoke(five)
                            }
                            onIsNewOpChange.invoke(false)

                            five += "5"
                            onValueChange.invoke(five)
                        }
                    )
            ) {
                Text(
                    text = "5",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var six = textState
                            if (isNewOp) {
                                six = ""
                                onValueChange.invoke(six)
                            }
                            onIsNewOpChange.invoke(false)

                            six += "6"
                            onValueChange.invoke(six)
                        }
                    )
            ) {
                Text(
                    text = "6",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFFFD9E2B))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            onOpChange.invoke("-")
                            onOldValueChange.invoke(textState)
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "-",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
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
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var one = textState
                            if (isNewOp) {
                                one = ""
                                onValueChange.invoke(one)
                            }
                            onIsNewOpChange.invoke(false)

                            one += "1"
                            onValueChange.invoke(one)
                        }
                    )
            ) {
                Text(
                    text = "1",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var two = textState
                            if (isNewOp) {
                                two = ""
                                onValueChange.invoke(two)
                            }
                            onIsNewOpChange.invoke(false)

                            two += "2"
                            onValueChange.invoke(two)
                        }
                    )
            ) {
                Text(
                    text = "2",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var three = textState
                            if (isNewOp) {
                                three = ""
                                onValueChange.invoke(three)
                            }
                            onIsNewOpChange.invoke(false)

                            three += "3"
                            onValueChange.invoke(three)
                        }
                    )
            ) {
                Text(
                    text = "3",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .background(Color(0xFFFD9E2B))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            onOpChange.invoke("+")
                            onOldValueChange.invoke(textState)
                            onIsNewOpChange.invoke(true)
                        }
                    )
            ) {
                Text(
                    text = "+",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
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
        Column(
            modifier = Modifier
                .weight(2f)
                .wrapContentSize(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var zero = textState
                            if (isNewOp) {
                                zero = ""
                                onValueChange.invoke(zero)
                            }
                            onIsNewOpChange.invoke(false)

                            zero += "0"
                            onValueChange.invoke(zero)
                        }
                    )
            ) {
                Text(
                    text = "0",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .matchParentSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF606264))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            var dot = textState
                            if (isNewOp) {
                                dot = ""
                                onValueChange.invoke(dot)
                            }
                            onIsNewOpChange.invoke(false)
                            if (!dot.contains(".")) {
                                dot += "."
                                onValueChange.invoke(dot)
                            }
                        }
                    )
            ) {
                Text(
                    text = ".",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .matchParentSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFD9E2B))
                    .border(width = .5.dp, Color(0xFF2C2F32))
                    .clickable(
                        enabled = true,
                        onClick = {
                            if (oldNumber.isNotEmpty()) {
                                var finalNumber = 0.0
                                when (op) {

                                    "*" -> {
                                        finalNumber = oldNumber.toDouble() * textState.toDouble()
                                    }
                                    "/" -> {
                                        finalNumber = oldNumber.toDouble() / textState.toDouble()
                                    }
                                    "+" -> {
                                        finalNumber = oldNumber.toDouble() + textState.toDouble()
                                    }
                                    "-" -> {
                                        finalNumber = oldNumber.toDouble() - textState.toDouble()
                                    }
                                }
                                onValueChange.invoke(finalNumber.toString())
                                onIsNewOpChange.invoke(true)
                            }
                        }
                    )
            ) {
                Text(
                    text = "=",
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.End,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .matchParentSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
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
            var textState: String by remember { mutableStateOf("0") }

            CalculatorTextField(
                textState = textState,
                modifier = Modifier.height(100.dp),
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