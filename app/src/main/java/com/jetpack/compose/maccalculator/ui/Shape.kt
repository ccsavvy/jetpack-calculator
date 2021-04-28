package com.jetpack.compose.maccalculator.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
)

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