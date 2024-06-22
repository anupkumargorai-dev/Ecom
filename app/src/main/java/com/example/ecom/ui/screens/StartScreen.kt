package com.example.ecom.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecom.R
import com.example.ecom.ui.screens.widgets.ElevatedButtonW
import com.example.ecom.ui.screens.widgets.OutlinedButtonW

@Composable
fun StartScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = R.drawable.wallpaper), contentDescription = ""
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButtonW(
                modifier = Modifier.padding(20.dp), btnTitle = "Login", colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Gray
                )
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButtonW(
                modifier = Modifier.padding(20.dp), btnTitle = "Sign Up",
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                borderStroke = BorderStroke(1.dp, Color.Black)
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun Show() {
    StartScreen()
}