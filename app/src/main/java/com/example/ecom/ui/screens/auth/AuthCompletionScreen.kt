package com.example.ecom.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecom.R
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.screens.widgets.ElevatedButtonW


@Composable
fun AuthCompletionScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 50.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.check),
                contentDescription = "checked"
            )

            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Successful!",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier
                    .padding(top = 10.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(),
                text = "You have successfully registered in our app and start working on it.",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 1.5.em,
                color = Color.Gray
            )

        }

        ElevatedButtonW(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            btnTitle = "Get Started",
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.red)
            ),
            fontSize = 17.sp
        ) {
            navHostController.navigate(NavRoute.MainScreen.name)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Auth() {
    AuthCompletionScreen(navHostController = rememberNavController())
}