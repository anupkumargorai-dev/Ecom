package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun DotView(
    height: Dp,
    weight: Dp
) {
    Box(
        modifier = Modifier
            .height(height)
            .width(weight)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}

@Composable
fun DotView2(
    height: Dp,
    weight: Dp
) {
    Box(
        modifier = Modifier
            .height(height)
            .width(weight)
            .clip(CircleShape)
            .background(Color.Black)
    )
}