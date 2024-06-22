package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ElevatedButtonW(
    modifier: Modifier,
    btnTitle: String,
    colors: ButtonColors,
    fontSize: TextUnit = 15.sp,
    onBtnClick: () -> Unit
) {
    ElevatedButton(
        modifier = modifier
            .fillMaxWidth(),
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 3.dp
        ),
        onClick = { onBtnClick() },
    ) {
        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = btnTitle,
            fontSize = fontSize,
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Composable
fun OutlinedButtonW(
    modifier: Modifier = Modifier,
    btnTitle: String,
    colors: ButtonColors,
    borderStroke: BorderStroke,
    onBtnClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth(),
        border = borderStroke,
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp
        ),
        onClick = { onBtnClick() },
    ) {
        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = btnTitle,
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif
        )
    }
}