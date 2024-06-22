package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.ecom.R



@Composable
fun ProductItem(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .width(150.dp)
            .border(0.3.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .padding(bottom = 8.dp, start = 5.dp, end = 5.dp)

    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.product),
            contentDescription = ""
        )
        Text(
            textAlign = TextAlign.Start,
            letterSpacing = 0.03.em,
            text = "Essence Mascara Lash Princess",
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
        )

        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = "$100.99",
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
                text = "4.95",
                fontSize = 12.sp,
                color = Color.Red,
                fontFamily = FontFamily.SansSerif,
            )
        }


    }
}

@Preview(showSystemUi = true)
@Composable
private fun Product() {
    ProductItem()
}