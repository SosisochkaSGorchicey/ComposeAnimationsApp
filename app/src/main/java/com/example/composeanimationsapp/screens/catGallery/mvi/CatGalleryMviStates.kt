package com.example.composeanimationsapp.screens.catGallery.mvi

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import com.example.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CatGalleryState(
    val catData: Flow<PagingData<Cat>> = emptyFlow()
)

@Immutable
sealed interface CatGalleryEvent {
    data object Init : CatGalleryEvent
}