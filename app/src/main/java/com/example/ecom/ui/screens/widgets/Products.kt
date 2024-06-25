package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecom.R
import com.example.ecom.data.api.models.response.Product
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.ui.theme.Red
import kotlinx.coroutines.launch


@Composable
fun ProductItem(modifier: Modifier = Modifier, product: Product? = null) {

    Column(
        modifier = modifier
            .width(150.dp)
            .border(0.3.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .padding(bottom = 8.dp, start = 5.dp, end = 5.dp)

    ) {
        AsyncImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            model = ImageRequest.Builder(LocalContext.current)
                .data(product?.thumbnail)
                .crossfade(true)
                .placeholder(R.drawable.product_placeholder)
                .error(R.drawable.product_placeholder)
                .build(),
            contentDescription = product?.title,
            imageLoader = ImageLoader(
                LocalContext.current
            ),
            contentScale = ContentScale.Crop
        )

        Text(
            textAlign = TextAlign.Start,
            letterSpacing = 0.03.em,
            lineHeight = 1.2.em,
            text = product?.title ?: "Essence Mascara Lash Princess",
            maxLines = 2,
            minLines = 2,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
        )

        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "₹${product?.price}" ?: "$100.99",
                fontSize = 12.sp,
                color = Color.Red,
                fontFamily = FontFamily.SansSerif,
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier
                    .width(10.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.active_rating),
                contentDescription = "rating"
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = product?.rating.toString() ?: "4.95",
                fontSize = 12.sp,
                color = Color.Red,
                fontFamily = FontFamily.SansSerif,
            )
        }


    }
}

@Composable
fun ProductHeader(modifier: Modifier = Modifier, type: String = "New Arrival") {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp),
            text = type,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.padding(end = 10.dp, top = 10.dp),
            text = "See all",
            color = Color.DarkGray,
            fontFamily = FontFamily.SansSerif,
            fontSize = 13.sp
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductSection(
    title: String,
    totalCount: Int,
    itemSize: Dp,
    listState: LazyListState,
    itemNumber: Int,
    products: List<Product>? = null,
    onProductClick:  (Product) -> Unit
) {
    var maxLines by remember {
        mutableIntStateOf(3)
    }
    val coroutineScope = rememberCoroutineScope()
    var isAddedAllProduct = false

    val moreOrCollapseIndicator = @Composable { scope: ContextualFlowRowOverflowScope ->
        val remainingItems = totalCount - scope.shownItemCount
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .background(color = Red, shape = RoundedCornerShape(100.dp))
                    .height(40.dp)
                    .width(130.dp)
                    .clickable {
                        if (remainingItems == 0) {
                            maxLines = 3
                            coroutineScope.launch {
                                listState.scrollToItem(itemNumber)
                            }
                        } else {
                            maxLines += 5
                        }
                    }
                    .padding(vertical = 2.dp, horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (remainingItems == 0) "Move to Top" else "Load More",
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    ProductHeader(type = title)

    val productItems = remember(products) { products.orEmpty() }


    ContextualFlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        maxItemsInEachRow = 2,
        itemCount = totalCount,
        maxLines = maxLines,
        overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
            minRowsToShowCollapse = 4,
            expandIndicator = moreOrCollapseIndicator,
            collapseIndicator = moreOrCollapseIndicator
        ),
    ) {
        if (!isAddedAllProduct) {
            productItems?.forEach { product ->
                key(product.id) {
                    ProductItem(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(itemSize)
                            .clickable {
                                onProductClick(product)
                            },
                        product = product
                    )
                }

            }
        }
        isAddedAllProduct = true
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Product() {
    ProductItem()
}