package com.pbaileyapps.layoutbasics.ui.box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme

@Composable
fun BoxLayout() {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Text(
                    text = "Box Layout",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(MaterialTheme.colors.background)
            ) {

                Text(
                    text = "Top Start",
                    modifier = Modifier.align(Alignment.TopStart),
                    color = Color.White
                )
                Text(
                    text = "Top Center",
                    modifier = Modifier.align(Alignment.TopCenter),
                    color = Color.White
                )
                Text(
                    text = "Top End",
                    modifier = Modifier.align(Alignment.TopEnd),
                    color = Color.White
                )
                Text(
                    text = "Center Start",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = Color.White
                )
                Text(
                    text = "Center",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
                Text(
                    text = "Center End",
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = Color.White
                )
                Text(
                    text = "Bottom Start",
                    modifier = Modifier.align(Alignment.BottomStart),
                    color = Color.White
                )
                Text(
                    text = "Bottom Center",
                    modifier = Modifier.align(Alignment.BottomCenter),
                    color = Color.White
                )
                Text(
                    text = "Bottom End",
                    modifier = Modifier.align(Alignment.BottomEnd),
                    color = Color.White
                )

            }
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        BoxLayout()
    }
}
