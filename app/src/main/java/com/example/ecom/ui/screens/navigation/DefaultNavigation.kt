package com.example.ecom.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.ecom.ui.screens.MainScreen
import com.example.ecom.ui.screens.auth.AuthCompletionScreen
import com.example.ecom.ui.screens.auth.LoginScreen
import com.example.ecom.ui.screens.auth.SignUpScreen
import com.example.ecom.ui.screens.cart.CartScreen
import com.example.ecom.ui.screens.home.HomeScreen
import com.example.ecom.ui.screens.onboarding.OnBoardingScreens
import com.example.ecom.ui.screens.search.SearchScreen
import com.example.ecom.ui.screens.trending.TreandingScreen

sealed class DefaultNavigation(val rout: String) {
    data object Starter : DefaultNavigation(NavRoute.STARTERS.name) {
        data object Onboarding : DefaultNavigation(NavRoute.ONBOARDING.name)
        data object Login : DefaultNavigation(NavRoute.LOGIN.name)
        data object Register : DefaultNavigation(NavRoute.REGISTER.name)
        data object AuthComplete : DefaultNavigation(NavRoute.STARTER_COMPLETE.name)
    }

    data object MainScreen : DefaultNavigation(NavRoute.MainScreen.name)

}

sealed class BottomNavNavigation(val rout: String) {
    data object BottomNav : DefaultNavigation(NavRoute.BOTTOM_NAV.name){
        data object Home : DefaultNavigation(NavRoute.HOME.name)
        data object Search : DefaultNavigation(NavRoute.SEARCH.name)
        data object Cart : DefaultNavigation(NavRoute.CART.name)
        data object Trending : DefaultNavigation(NavRoute.TRENDING.name)
    }
}


enum class NavRoute {
    STARTERS,
    ONBOARDING,
    LOGIN,
    REGISTER,
    STARTER_COMPLETE,
    HOME,
    BOTTOM_NAV,
    SEARCH,
    CART,
    TRENDING,
    MainScreen
}

// Nav graph
@Composable
fun DefaultNavigationImp(modifier: Modifier = Modifier,isLoggedIn: Boolean = false) {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController,
        startDestination = DefaultNavigation.Starter.rout

    ) {
        navigation(
            startDestination = DefaultNavigation.Starter.Onboarding.rout,
            route = DefaultNavigation.Starter.rout
        ) {
            composable(route = DefaultNavigation.Starter.Onboarding.rout) {
                OnBoardingScreens(navHostController)
            }
            composable(route = DefaultNavigation.Starter.Login.rout) {
                LoginScreen(navHostController)
            }
            composable(route = DefaultNavigation.Starter.Register.rout) {
                SignUpScreen(navHostController)
            }
            composable(route = DefaultNavigation.Starter.AuthComplete.rout) {
                AuthCompletionScreen(navHostController = navHostController)
            }
        }

        composable(route = DefaultNavigation.MainScreen.rout){
            MainScreen()
        }

    }
}

@Composable
fun BottomNavNavigationImp(modifier: Modifier = Modifier, navController: NavHostController,) {
    NavHost(navController = navController, startDestination = BottomNavNavigation.BottomNav.rout) {
        navigation(
            startDestination = BottomNavNavigation.BottomNav.Home.rout,
            route = BottomNavNavigation.BottomNav.rout
        ){
            composable(route = BottomNavNavigation.BottomNav.Home.rout){
                HomeScreen()
            }
            composable(route = BottomNavNavigation.BottomNav.Search.rout){
                SearchScreen()
            }
            composable(route = BottomNavNavigation.BottomNav.Cart.rout){
                CartScreen()
            }
            composable(route = BottomNavNavigation.BottomNav.Trending.rout){
                TreandingScreen()
            }
        }
    }
}