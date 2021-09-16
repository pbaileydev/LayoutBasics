package com.pbaileyapps.layoutbasics.ui.listToDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun CatDetailsPreviewDark() {
    LayoutBasicsTheme(darkTheme = true) {
        CatDetails(1) { }
    }
}

@Composable
fun CatDetails(
    catId: Int,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    val cat: Cats = remember(catId) {
        PuppyAdoptionRepo.getCat(
            catId, context
        )
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                item { CatHeader(cat.catImage, navigateUp) }
                item { CatDetailBody(cat) }
            }
        }
    }
}

// Show up button, banner of the cat, custom app bar.
@Composable
private fun CatHeader(
    catImage: Int,
    navigateUp: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(id = catImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White
        ) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun CatDetailBody(
    cat: Cats
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = cat.catName,
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = cat.catDescription,
            modifier = Modifier.alpha(0.8f),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = cat.catAbout,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .alpha(0.7f),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Justify
        )
    }
}