package com.pbaileyapps.layoutbasics.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
                CustomRow(
                    name = "Pizza",
                    "$5",
                    painter = painterResource(id = R.drawable.pizza),
                    icon = painterResource(
                        id = R.drawable.pizza
                    )
                )
                CustomRow(
                    name = "Coffee",
                    "$1",
                    painter = painterResource(id = R.drawable.coffee),
                    icon = painterResource(
                        id = R.drawable.coffee
                    )
                )
                CustomRow(
                    name = "Salad",
                    "$2",
                    painter = painterResource(id = R.drawable.salad),
                    icon = painterResource(
                        id = R.drawable.salad
                    )
                )
                CustomRow(
                    name = "Ice Cream", "$.63",
                    painter = painterResource(id = R.drawable.ice_cream),
                    icon = painterResource(id = R.drawable.ice_cream)
                )
            }
        }
    }
}

@Composable
fun CustomRow(name: String, cost: String, painter: Painter, icon: Painter) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(72.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(1f),
                painter = painter, contentDescription = "Food",
            )
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomEnd),
                painter = icon, contentDescription = "icon"
            )
        }
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = cost,
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
