package com.pbaileyapps.layoutbasics.ui.listToDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pbaileyapps.layoutbasics.R
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        CatsList { }
    }
}

@Composable
fun CatsList(
    selectedCat: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pet_paw),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "Cats",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    ) {
        CatsListBody(selectedCat)
    }
}

// Start of List
@Composable
private fun CatsListBody(
    selectedCat: (Int) -> Unit
) {
    val context = LocalContext.current
    val cats: List<Cats> = PuppyAdoptionRepo.getCatsList(context)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(cats) { cat ->
            CatRow(cat, selectedCat)
        }
    }
}

// Item row for one cat.
@Composable
private fun CatRow(
    cat: Cats,
    selectedCat: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = { selectedCat(cat.catId) })
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cat.catImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(
                text = cat.catName,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}