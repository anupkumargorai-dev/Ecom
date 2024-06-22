package com.example.ecom.ui.screens.auth


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecom.R
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.screens.widgets.BasicTextFieldWidget
import com.example.ecom.ui.screens.widgets.ElevatedButtonW

@Composable
fun LoginScreen( navHostController: NavHostController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(140.dp)
                .padding(top = 40.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.logo_m),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(80.dp))

        Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
            Text(
                text = "Welcome!",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "please login or sign up to continue our app",
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(40.dp))

            BasicTextFieldWidget(
                title = "Email",
                placeholder = "alex.geol@gmail.com",
                keyboardType = KeyboardType.Email,
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

            Spacer(modifier = Modifier.height(40.dp))

            ElevatedButtonW(
                modifier = Modifier.padding(0.dp),
                btnTitle = "Login",
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colorResource(id = R.color.red)
                ),
                fontSize = 17.sp
            ) {

            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.5.dp)
                        .background(color = Color.LightGray)
                )

                Text(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    text = "OR",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.5.dp)
                        .background(color = Color.LightGray)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Transparent),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "google",
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Transparent),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "facebook"
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))

                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Transparent),
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "apple"
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have account?",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.09.em
                )
                Text(
                    modifier = Modifier
                        .padding(start = 1.dp)
                        .clickable {
                            navHostController.navigate(NavRoute.REGISTER.name)
                        },
                    text = "Sign Up",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.09.em
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Login() {
    LoginScreen()
}