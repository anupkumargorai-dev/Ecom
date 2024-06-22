package com.example.ecom.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.ecom.data.models.home.HomeViewpagerContent
import com.example.ecom.ui.screens.navigation.DefaultNavigationImp
import com.example.ecom.ui.screens.widgets.DotView
import com.example.ecom.ui.screens.widgets.DotView2
import com.example.ecom.ui.screens.widgets.MainAppBar
import com.example.ecom.utils.DataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(

    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            LazyRow {
                val categories = DataProvider.provideHomeTopCategories()
                items(categories.size) { it ->
                    AsyncImage(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth(),
                        model = categories[it].image,
                        contentDescription = categories[it].title,
                        imageLoader = ImageLoader(
                            LocalContext.current
                        )
                    )
                }
            }
            HomeViewpager(list = DataProvider.provideHomeViewPagerContent())
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Home() {
    HomeScreen()
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