package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTextFieldWidget(
    modifier: Modifier = Modifier,
    title: String = "Username",
    placeholder: String = "Alendra",
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onvalueChanged: (String) -> Unit
) {
    var valueChanged by remember {
        mutableStateOf("")
    }
    val interactionSource = remember { MutableInteractionSource() }
    var isVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier.weight(1f),
                value = valueChanged,
                onValueChange = {
                    valueChanged = it
                    onvalueChanged(it)
                },
                textStyle = TextStyle.Default.copy(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.DarkGray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType,
                ),
                singleLine = true,
                visualTransformation = if (isVisible || !isPassword) VisualTransformation.None else PasswordVisualTransformation()
            ) { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = valueChanged,
                    singleLine = true,
                    enabled = true,
                    innerTextField = innerTextField,
                    interactionSource = interactionSource,
                    placeholder = { Text(text = placeholder, color = Color.Gray) },
                    contentPadding = PaddingValues(
                        top = 0.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = 0.dp
                    ),
                    visualTransformation = VisualTransformation.None,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }

            if (isPassword) {
                IconButton(onClick = { isVisible = !isVisible }) {
                    if (isVisible) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "Show Password",
                            tint = Color.Gray
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "Hide Password",
                            tint = Color.Gray
                        )
                    }
                }
            } else {
                IconButton(
                    modifier = Modifier.align(Alignment.Top),
                    onClick = { }) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "", tint = Color.Gray)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(color = Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldWithHeaders() {
    BasicTextFieldWidget() {}
}