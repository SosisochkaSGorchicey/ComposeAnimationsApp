package com.example.composeanimationsapp.screens.catGallery.mvi

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.composeanimationsapp.utils.MviViewModel
import com.example.domain.usecases.GetCatsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class CatGalleryViewModel(
    private val getCatsUseCase: GetCatsUseCase
) : MviViewModel<CatGalleryState, Any, Any>(
    initialState = CatGalleryState()
) {
    init {
        onEvent(CatGalleryEvent.Init)
    }

    override fun onEvent(event: Any) {
        when (event) {
            CatGalleryEvent.Init -> getCatData()
        }
    }

    private fun getCatData() = intent {
        reduce {
            state.copy(
                catData = Pager(
                    PagingConfig(
                        pageSize = 10,
                        enablePlaceholders = true
                    ),
                    pagingSourceFactory = { getCatsUseCase() }
                ).flow
                    .cachedIn(screenModelScope)
                    .flowOn(Dispatchers.IO)
            )
        }
    }
}