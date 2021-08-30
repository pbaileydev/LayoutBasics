package com.pbaileyapps.layoutbasics.ui.row

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
fun RowLayout() {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Text(
                    text = "Row Layout",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
            }
        ) {
            Row(
    modifier = Modifier.fillMaxWidth().padding(8.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = "Pizza",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(start = 20.dp)
    )
    Text(
        text = "$5",
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(start = 20.dp)
    )
}
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        RowLayout()
    }
}
