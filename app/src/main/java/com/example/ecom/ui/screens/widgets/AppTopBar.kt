package com.example.ecom.ui.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecom.R

@Composable
fun MainAppBar(modifier: Modifier = Modifier,name : String= "Anup") {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.Menu, contentDescription = "menu"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "$name",
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp)

        }


        Spacer(modifier = Modifier.weight(1f))

        Row {
            Image(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.Search, contentDescription = "menu"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.user), contentDescription = "menu"
            )
        }

    }
}

@Composable
fun DefaultAppBar(modifier: Modifier = Modifier,title: String = "Home",onBackClick: () -> Unit) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(40.dp).clickable { onBackClick() },
            painter = painterResource(id = R.drawable.left_24), contentDescription = "back"
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier,
            text = title, fontFamily = FontFamily.SansSerif,fontSize = 20.sp)

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AppBar() {
    MainAppBar()
}

@Preview(showBackground = true)
@Composable
private fun AppBarDefault() {
    DefaultAppBar(){}
}