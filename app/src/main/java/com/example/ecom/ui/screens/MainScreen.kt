package com.example.ecom.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ecom.ui.screens.bottombar.BottomBarScreen
import com.example.ecom.ui.screens.home.BottomBar
import com.example.ecom.ui.screens.home.HomeScreen
import com.example.ecom.ui.screens.navigation.BottomNavNavigationImp
import com.example.ecom.ui.screens.navigation.DefaultNavigationImp
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.screens.widgets.DefaultAppBar
import com.example.ecom.ui.screens.widgets.MainAppBar


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    val bottomNavScreens =
        listOf(NavRoute.HOME.name, NavRoute.SEARCH.name, NavRoute.CART.name, NavRoute.TRENDING.name)

    val isBottomNavScreen = currentDestination?.route in bottomNavScreens
    val appBarTitle = if(currentDestination?.route?.contains( NavRoute.PRODUCT_DETAILS_SCREEN.name) == true) "Product Details" else currentDestination?.route.toString()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (isBottomNavScreen) MainAppBar(modifier = Modifier.padding(horizontal = 10.dp), name = "PiCkTo") else DefaultAppBar(title = appBarTitle){
                navController.popBackStack()
            }
        },
        bottomBar = { if (isBottomNavScreen) BottomBar(navController = navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BottomNavNavigationImp(navController = navController)
        }
    }
}



@Preview(showSystemUi = true)
@Composable
private fun MainScr() {
    MainScreen()
    //BottomBar(navController = rememberNavController())
}
