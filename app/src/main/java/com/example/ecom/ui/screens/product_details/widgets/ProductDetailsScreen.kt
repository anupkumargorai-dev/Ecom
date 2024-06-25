package com.example.ecom.ui.screens.product_details.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecom.R
import com.example.ecom.data.api.models.response.Product
import com.example.ecom.ui.theme.Red


@Composable
fun ProductDetailsScreen(modifier: Modifier = Modifier, product: Product) {
    Column {
        ProductCatalogs(list = product.images)

        Row(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            for (i in 1..5) {
                if (i <= (product.rating?.toInt() ?: 0)) {
                    Image(
                        modifier = Modifier
                            .padding(3.dp)
                            .size(15.dp),
                        painter = painterResource(id = R.drawable.active_rating),
                        contentDescription = ""
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .padding(3.dp)
                            .size(15.dp),
                        painter = painterResource(id = R.drawable.inactive_rating),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(color = Color.Gray)
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            text = product.title.toString(),
            fontFamily = FontFamily.SansSerif,
            fontSize = 23.sp
        )

        Text(
            modifier = Modifier.padding(start = 10.dp, top = 15.dp), text = "₹${product.price}",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(start = 10.dp, top = 20.dp), text = "Description",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            color = Color.DarkGray
        )

        Text(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
            text = product.description.toString(),
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Justify,
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            var isAdded by remember { mutableStateOf(false) }
            Button(onClick = {
                isAdded = !isAdded
            }, modifier = Modifier) {
                Image(
                    modifier = Modifier.padding(end = 3.dp),
                    colorFilter = ColorFilter.tint(Color.White),
                    imageVector = if (isAdded) Icons.Default.Check else Icons.Default.AddShoppingCart, contentDescription = "cart"
                )
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = if (isAdded) "Added" else "Add to Cart",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Buy Now",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp
                )
            }
        }

    }
}