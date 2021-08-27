package com.pbaileyapps.layoutbasics.ui.constraint

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
import androidx.constraintlayout.compose.ConstraintLayout
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        ConstraintLayouts()
    }
}

@Composable
fun ConstraintLayouts() {

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                Text(
                    text = "Constraint Layout",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h5
                )
            }
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (one, two) = createRefs()

                Text(
                    text = "One",
                    modifier = Modifier.constrainAs(one) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(two.start)
                    }
                )

                Text(
                    text = "Two",
                    modifier = Modifier.constrainAs(two) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(one.end)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }
}