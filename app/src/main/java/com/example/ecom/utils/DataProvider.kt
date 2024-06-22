package com.example.ecom.utils

import com.example.ecom.R
import com.example.ecom.data.models.home.HomeTopCategories
import com.example.ecom.data.models.home.HomeViewpagerContent
import com.pick.pickto.data.models.OnBoardingModel

object DataProvider {

    fun provideOnBoardingScreens() : List<OnBoardingModel>{
        return listOf(
            OnBoardingModel(
                img = R.drawable.onboarding_1,
                header = "20% Discount \nNew Arrival Products",
                title = "Unwrap New Arrivals with 20% Off – Elevate Your Style Today!"
            ),
            OnBoardingModel(
                img = R.drawable.shoping2,
                header = "Discover Fresh Finds \nwith Fast Delivery!",
                title = "Shop Now and Enjoy 20% Off the Latest Trends – Speedy Delivery Guaranteed!"
            ),
            OnBoardingModel(
                img = R.drawable.shoping3,
                header = "Fast Delivery Even and Save 20% on All New Arrivals ",
                title = "Shop Now and Enjoy 20% Off the Latest Trends – At Your Door in 30 Minutes!"
            )
        )
    }

    fun provideHomeTopCategories() : List<HomeTopCategories> {
        return listOf(
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/033f3268031fa0ba.jpg?q=20",
                title = "Categories"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/42f9a853f9181279.jpg?q=20",
                title = "Mobiles"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/cbcb478744635781.jpg?q=20",
                title = "Fashion"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/913e96c334d04395.jpg?q=20",
                title = "Electronics"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/3e6d75f631ab6055.jpg?q=20",
                title = "Toys and Baby"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/fk-p-flap/160/160/image/bd8fcc0b04234711.jpg?q=20",
                title = "Smart Gadgets"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/fk-p-flap/160/160/image/07d71cbddb6083ad.jpg?q=20",
                title = "Appliances"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/fk-p-flap/160/160/image/418dfd603e730185.jpg?q=20",
                title = "Sports"
            ),
            HomeTopCategories(
                image = "https://rukminim2.flixcart.com/flap/160/160/image/818e0398f9dabd3e.JPG?q=20",
                title = "Cars and Bikes"
            )
        )
    }

    fun provideHomeViewPagerContent() : List<HomeViewpagerContent> {
        return listOf(
            HomeViewpagerContent(
                title = "page1",
                image = "https://rukminim2.flixcart.com/fk-p-flap/1442/641/image/012e91db73b0466f.jpg?q=80"
            ),
            HomeViewpagerContent(
                title = "page2",
                image = "https://rukminim2.flixcart.com/fk-p-flap/1442/641/image/a101cbc69c083c28.jpeg?q=20"
            ),
            HomeViewpagerContent(
                title = "page3",
                image = "https://rukminim2.flixcart.com/fk-p-flap/1442/641/image/4c44c56f2f95035e.jpg?q=20"
            ),
        )
    }
}

