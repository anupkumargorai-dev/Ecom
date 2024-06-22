package com.example.ecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.example.ecom.ui.screens.navigation.DefaultNavigationImp
import com.example.ecom.ui.screens.onboarding.OnBoardingScreens
import com.example.ecom.ui.theme.EcomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            EcomTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {}
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    DefaultNavigationImp(isLoggedIn = false)
   // HomeScreen()
   // MainScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcomTheme {
        Greeting("Android")
    }
}