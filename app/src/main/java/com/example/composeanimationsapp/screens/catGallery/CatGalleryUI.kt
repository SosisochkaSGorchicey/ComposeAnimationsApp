package com.example.composeanimationsapp.screens.catGallery

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.composeanimationsapp.screens.catGallery.components.ErrorDisplay
import com.example.composeanimationsapp.screens.catGallery.components.LoadingIndicator
import com.example.composeanimationsapp.screens.catGallery.mvi.CatGalleryState

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun CatGalleryUI(
    padding: PaddingValues,
    state: CatGalleryState
) {
    val catPagingData = state.catData.collectAsLazyPagingItems()

    val infiniteTransition = rememberInfiniteTransition(label = "infiniteColorAnimation")
    val color by infiniteTransition.animateColor(
        initialValue = MaterialTheme.colorScheme.background,
        targetValue = MaterialTheme.colorScheme.onSurface,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "colorAnimation"
    )

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(color)
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                count = catPagingData.itemCount,
                key = { it }
            ) {
                AsyncImage(
                    modifier = Modifier
                        .animateItemPlacement(),
                    model = catPagingData[it]?.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        catPagingData.apply {
            when {
                loadState.refresh is LoadState.Error -> ErrorDisplay(retry = catPagingData::retry)

                loadState.append is LoadState.Error -> ErrorDisplay(retry = catPagingData::retry)

                loadState.append is LoadState.Loading -> LoadingIndicator()

                loadState.refresh is LoadState.Loading -> LoadingIndicator()
            }
        }
    }
}