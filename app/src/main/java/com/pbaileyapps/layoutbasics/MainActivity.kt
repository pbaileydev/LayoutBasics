package com.pbaileyapps.layoutbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text("Android Cafe",modifier= Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                fontSize = 48.sp,textAlign = TextAlign.Center,color=Color.White,)
                var painter = painterResource(id = R.drawable.pizza)
                CustomRow(name = "Pizza", painter = painter)
                painter = painterResource(id = R.drawable.coffee)
                CustomRow(name = "Coffee", painter = painter)
                painter = painterResource(id = R.drawable.salad)
                CustomRow(name = "Salad", painter = painter)
                painter = painterResource(id = R.drawable.ice_cream)
                CustomRow(name = "Coffee", painter = painter)
            }
        }
    }
}
@Composable
fun CustomRow(name:String,painter: Painter){
    Row(modifier = Modifier
        .fillMaxWidth(.85f)
        .height(96.dp)
        .background(Color.LightGray)
        .border(3.dp, Color.DarkGray)
        .padding(10.dp),
    verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painter, contentDescription = "Yummy",
                modifier = Modifier.height(72.dp)
            )


        Text(text = name, color = Color.DarkGray, fontSize = 24.sp, fontFamily = FontFamily.SansSerif)

    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutBasicsTheme {
        Greeting("Android")
    }
}