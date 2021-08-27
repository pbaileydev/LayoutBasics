package com.pbaileyapps.layoutbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pbaileyapps.layoutbasics.ui.AndroidCafe
import com.pbaileyapps.layoutbasics.ui.box.BoxLayout
import com.pbaileyapps.layoutbasics.ui.column.ColumnLayout
import com.pbaileyapps.layoutbasics.ui.constraint.ConstraintLayouts
import com.pbaileyapps.layoutbasics.ui.row.RowLayout
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutBasicsTheme {
                AndroidCafe()
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun AndroidCafePreview() {
    LayoutBasicsTheme(darkTheme = true) {
        AndroidCafe()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ColumnLayoutPreview() {
    LayoutBasicsTheme(darkTheme = true) {
        ColumnLayout()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun RowLayoutPreview() {
    LayoutBasicsTheme(darkTheme = true) {
        RowLayout()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ConstraintLayoutPreview() {
    LayoutBasicsTheme(darkTheme = true) {
        ConstraintLayouts()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun BoxLayoutPreview() {
    LayoutBasicsTheme(darkTheme = true) {
        BoxLayout()
    }
}