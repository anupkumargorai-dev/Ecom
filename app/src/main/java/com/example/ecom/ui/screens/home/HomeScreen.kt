package com.example.ecom.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.Product
import com.example.ecom.data.models.home.HomeViewpagerContent
import com.example.ecom.ui.screens.navigation.NavRoute
import com.example.ecom.ui.screens.widgets.DotView
import com.example.ecom.ui.screens.widgets.DotView2
import com.example.ecom.ui.screens.widgets.ProductSection
import com.example.ecom.ui.screens.widgets.ShowLoading
import com.example.ecom.ui.viewmodel.ProductViewModel
import com.example.ecom.utils.DataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val itemSize = (screenWidth / 2) - 24.dp

    val listState = rememberLazyListState()

    val productState by viewModel.products.observeAsState()
    val bestSellerState by viewModel.bestSellerProducts.observeAsState()
    val trendingState by viewModel.trendingProducts.observeAsState()


    LaunchedEffect(key1 = Unit) {
        viewModel.getProducts()
        viewModel.getBestSellerProducts()
        viewModel.getTrendingProducts()
    }

    Scaffold(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = listState
        ) {

            item {
                HomeViewpager(list = DataProvider.provideHomeViewPagerContent())
            }

            item {
                LazyRow(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    val categories = DataProvider.provideHomeTopCategories()
                    items(categories.size) { it ->
                        AsyncImage(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .padding(5.dp)
                                .fillMaxWidth(),
                            model = categories[it].image,
                            contentDescription = categories[it].title,
                            imageLoader = ImageLoader(
                                LocalContext.current
                            )
                        )
                    }
                }
            }

            item {
                when (productState) {
                    is NetworkResult.Loading -> {
                        ShowLoading()
                    }

                    is NetworkResult.Success -> {
                        productState?.data?.products?.let { products ->
                            ProductSection(
                                title = "New Arrival",
                                totalCount = products.size,
                                itemSize = itemSize,
                                listState = listState,
                                itemNumber = 2,
                                products = products,
                                onProductClick = { product: Product ->
                                    println(">>>>>>>>>product: $product")
                                    val productJson = Json.encodeToString(product)
                                    navHostController.navigate("${NavRoute.PRODUCT_DETAILS_SCREEN.name}/?productJson=${productJson}")
                                }
                            )
                        }
                    }

                    is NetworkResult.Error -> {}
                    null -> {
                        ShowLoading()

                    }
                }
            }

            item {
                when (bestSellerState) {
                    is NetworkResult.Loading -> {
                        ShowLoading()
                    }

                    is NetworkResult.Success -> {
                        bestSellerState?.data?.products?.let { products ->
                            ProductSection(
                                title = "Best Seller",
                                totalCount = products.size,
                                itemSize = itemSize,
                                listState = listState,
                                itemNumber = 3,
                                products = products,
                                onProductClick = { product: Product ->
                                    println(">>>>>>>>>product: $product")
                                    val productJson = Json.encodeToString(product)
                                    navHostController.navigate("${NavRoute.PRODUCT_DETAILS_SCREEN.name}/?productJson=${productJson}")
                                }
                            )
                        }

                    }

                    is NetworkResult.Error -> {}
                    null -> {
                        ShowLoading()
                    }
                }

            }

            item {
                when (trendingState) {
                    is NetworkResult.Loading -> {
                        ShowLoading()
                    }

                    is NetworkResult.Success -> {
                        trendingState?.data?.products?.let { products ->
                            ProductSection(
                                title = "Trending",
                                totalCount = products.size,
                                itemSize = itemSize,
                                listState = listState,
                                itemNumber = 4,
                                products = products,
                                onProductClick = { product: Product ->
                                    println(">>>>>>>>>product: $product")
                                    val productJson = Json.encodeToString(product)
                                    navHostController.navigate("${NavRoute.PRODUCT_DETAILS_SCREEN.name}/?productJson=${productJson}")
                                }
                            )
                        }
                    }

                    is NetworkResult.Error -> {}
                    null -> {
                        ShowLoading()
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Home() {
    HomeScreen(navHostController = rememberNavController())
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeViewpager(modifier: Modifier = Modifier, list: List<HomeViewpagerContent>) {
    val pagerState = rememberPagerState(pageCount = { list.size })
    val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(235.dp)
                .padding(top = 5.dp)
        ) {
            HorizontalPager(
                modifier = Modifier.height(200.dp),
                state = pagerState,
                contentPadding = PaddingValues(0.dp),
                pageSpacing = 2.dp,
            ) { page ->
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 0.dp)
                        .height(200.dp),
                    model = list[page].image,
                    clipToBounds = true,
                    contentDescription = list[page].title,
                    imageLoader = ImageLoader(
                        LocalContext.current
                    )
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                list.forEach {
                    if (list.indexOf(it) == pagerState.currentPage) {
                        DotView2(height = 10.dp, weight = 10.dp)
                    } else {
                        DotView(height = 10.dp, weight = 10.dp)
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                }
            }

            // Start auto-scroll effect
            LaunchedEffect(isDraggedState) {
                snapshotFlow { isDraggedState.value }
                    .collectLatest { isDragged ->
                        if (!isDragged) {
                            while (true) {
                                delay(3000)
                                runCatching {
                                    pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                                }
                            }
                        }
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePager() {
    HomeViewpager(list = DataProvider.provideHomeViewPagerContent())
}