package com.example.ecom.ui.screens.product_details.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecom.R


fun getCatalogsDemo(): List<Int> {
    return listOf(
        R.drawable.jordon_1,
        R.drawable.jordon_2,
        R.drawable.jordon_3,
        R.drawable.jordon_4,
    )
}


@Composable
fun ProductCatalogs(modifier: Modifier = Modifier, list: List<String>? = null) {
    var selectedImage by remember {
        mutableStateOf("")
    }
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            list?.size?.let {
                items(it) { it ->
                    AsyncImage(
                        modifier = Modifier
                            .size(70.dp)
                            .border(
                                width = 1.dp,
                                color = if (selectedIndex == it) Color.Black else Color.Transparent,
                                shape = if (selectedIndex == it) RoundedCornerShape(10.dp) else RoundedCornerShape(
                                    0.dp
                                )
                            )
                            .clickable {
                                selectedIndex = it
                                selectedImage = list[it]
                                println(">>>>>>imgeclaicke ${list[it]}")
                            },
                        model = ImageRequest.Builder(LocalContext.current).data(list[it])
                            .crossfade(true)
                            .placeholder(R.drawable.loading_mid)
                            .error(R.drawable.error)
                            .build(),
                        contentDescription = "Catalog"
                    )
                }
            }
        }
        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            model = ImageRequest.Builder(LocalContext.current).data(list?.get(selectedIndex))
                .crossfade(true)
                .placeholder(R.drawable.loading_mid)
                .error(R.drawable.error).build(),
            contentDescription = "Catalog"
        )


    }
}


@Preview(showSystemUi = true)
@Composable
private fun Product() {
    ProductCatalogs()
}