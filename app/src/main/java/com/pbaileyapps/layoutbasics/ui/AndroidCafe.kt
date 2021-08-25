package com.pbaileyapps.layoutbasics.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pbaileyapps.layoutbasics.R
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme

@Composable
fun AndroidCafe() {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Text(
                    text = "Android Cafe",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.h4
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CustomRow("Pizza", painterResource(id = R.drawable.pizza))
                CustomRow("Coffee", painterResource(id = R.drawable.coffee))
                CustomRow("Salad", painterResource(id = R.drawable.salad))
                CustomRow("Ice Cream", painterResource(id = R.drawable.ice_cream))
            }
        }
    }
}

@Composable
private fun CustomRow(name: String, painter: Painter) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painter, contentDescription = "Yummy",
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        AndroidCafe()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewLight() {
    LayoutBasicsTheme(darkTheme = false) {
        AndroidCafe()
    }
}