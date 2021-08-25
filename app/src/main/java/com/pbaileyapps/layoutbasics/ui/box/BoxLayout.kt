package com.pbaileyapps.layoutbasics.ui.box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

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