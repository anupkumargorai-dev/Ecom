package com.example.ecom.ui.screens.auth

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecom.R
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.screens.widgets.BasicTextFieldWidget
import com.example.ecom.ui.screens.widgets.ElevatedButtonW

@Composable
fun SignUpScreen(navHostController: NavHostController = rememberNavController()) {

    var onCheckedChanged by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        Image(
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp),
            painter = painterResource(id = R.drawable.logo_m),
            contentDescription = "logo"
        )

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Sign Up",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            textAlign = TextAlign.Start,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            text = "Create an account to continue",
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(30.dp))

        BasicTextFieldWidget(
            title = "User Name",
            placeholder = "Alex Geol",
            keyboardType = KeyboardType.Text,
            onvalueChanged = {

            }
        )

        BasicTextFieldWidget(
            modifier = Modifier.padding(top = 20.dp),
            title = "Email",
            isPassword = false,
            keyboardType = KeyboardType.Email,
            placeholder = "alex.geol@gmail.com",
            onvalueChanged = {

            }
        )

        BasicTextFieldWidget(
            modifier = Modifier.padding(top = 20.dp),
            title = "Password",
            isPassword = true,
            keyboardType = KeyboardType.Password,
            placeholder = "*********",
            onvalueChanged = {

            }
        )

        BasicTextFieldWidget(
            modifier = Modifier.padding(top = 20.dp),
            title = "Confirm Password",
            isPassword = true,
            keyboardType = KeyboardType.Password,
            placeholder = "*********",
            onvalueChanged = {

            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = onCheckedChanged, onCheckedChange = { onCheckedChanged = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.red),
                    checkmarkColor = Color.White
                )
            )
            Text(
                text = "By Creating an account you have to agree with our terms and conditions",
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedButtonW(
            modifier = Modifier.padding(0.dp),
            btnTitle = "Sign Up",
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.red)
            ),
            fontSize = 17.sp
        ) {
            navHostController.navigate(NavRoute.STARTER_COMPLETE.name)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignUP() {
    SignUpScreen()
}