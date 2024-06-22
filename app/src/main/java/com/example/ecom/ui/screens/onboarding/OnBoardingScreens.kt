package com.example.ecom.ui.screens.onboarding

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.viewmodel.ProductViewModel
import com.example.ecom.utils.DataProvider
import com.pick.pickto.data.models.OnBoardingModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreens(
    navHotController: NavHostController = rememberNavController(),
     viewModel : ProductViewModel = hiltViewModel()
) {
    val productState by viewModel.products.observeAsState()

    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        viewModel.getProducts()
    }

    productState?.let {
        println(">>>>>>>>>>>>"+productState?.data)
    }



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            HorizontalPager(state = pagerState, modifier = Modifier.weight(0.3f)) { page ->
                when (page) {
                    0 -> {
                        OnBoarding1(DataProvider.provideOnBoardingScreens()[0])
                    }

                    1 -> {
                        OnBoarding1(DataProvider.provideOnBoardingScreens()[1])
                    }

                    2 -> {
                        OnBoarding1(DataProvider.provideOnBoardingScreens()[2])
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 50.dp, top = 80.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                for (i in 0..2) {
                    if (i == pagerState.currentPage) {
                        DotView2()
                    } else {
                        DotView()
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                FloatingActionButton(
                    modifier = Modifier
                        .padding(end = 20.dp),
                    onClick = {
                        if (pagerState.currentPage < 2) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                            }
                        }
                        if (pagerState.currentPage == 2) {
                            navHotController.navigate(NavRoute.LOGIN.name)
                        }
                    }) {
                    if (pagerState.currentPage == 2) {
                        Text(modifier = Modifier.padding(horizontal = 20.dp), text = "Get Started")
                    } else {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }


}

@Composable
fun OnBoarding1(onBoardingModel: OnBoardingModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = onBoardingModel.img),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = onBoardingModel.header,
            fontSize = 25.sp,
            letterSpacing = 0.05.em,
            lineHeight = 1.5.em,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = onBoardingModel.title,
            fontSize = 15.sp,
            letterSpacing = 0.05.em,
            lineHeight = 1.5.em,
            color = Color.DarkGray,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
fun DotView() {
    Box(
        modifier = Modifier
            .height(8.dp)
            .width(15.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}

@Composable
fun DotView2() {
    Box(
        modifier = Modifier
            .height(8.dp)
            .width(40.dp)
            .clip(CircleShape)
            .background(Color.Black)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun OnBoarding() {
    OnBoardingScreens()
}

@Preview(showSystemUi = true)
@Composable
private fun DotViews() {
    DotView2()
}