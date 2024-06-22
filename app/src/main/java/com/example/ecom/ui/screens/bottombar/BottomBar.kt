package com.example.ecom.ui.screens.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecom.R
import com.example.ecom.ui.screens.navigation.NavRoute


sealed class BottomBarScreen(
    val route : String,
    val selectedIcon : Int,
    val unSelectedIcon : Int,
    val title : String
){
    data object Home : BottomBarScreen(
        route = NavRoute.HOME.name,
        selectedIcon = R.drawable.home_selected,
        unSelectedIcon = R.drawable.home_unselected,
        title = "Home"
    )

    data object Search : BottomBarScreen(
        route = NavRoute.SEARCH.name,
        selectedIcon = R.drawable.search_selected,
        unSelectedIcon = R.drawable.search_unselected,
        title = "Search"
    )

    data object Cart : BottomBarScreen(
        route = NavRoute.CART.name,
        selectedIcon = R.drawable.cart_selected,
        unSelectedIcon = R.drawable.cart_unselected,
        title = "Cart"
    )

    data object Trending : BottomBarScreen(
        route = NavRoute.TRENDING.name,
        selectedIcon = R.drawable.trending_selected,
        unSelectedIcon = R.drawable.trending_unselected,
        title = "Trending"
    )
}