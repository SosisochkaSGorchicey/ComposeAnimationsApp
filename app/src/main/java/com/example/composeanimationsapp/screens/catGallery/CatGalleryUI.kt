package com.example.composeanimationsapp.screens.catGallery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.composeanimationsapp.screens.catGallery.mvi.CatGalleryState

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun CatGalleryUI(
    padding: PaddingValues,
    state: CatGalleryState
) {
    val catPagingData = state.catData.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        items(
            count = catPagingData.itemCount,
            key = { it }
        ) {
            AsyncImage(
                modifier = Modifier.animateItemPlacement(),
                model = catPagingData[it]?.imageUrl,
                contentDescription = null
            )
        }
    }
}