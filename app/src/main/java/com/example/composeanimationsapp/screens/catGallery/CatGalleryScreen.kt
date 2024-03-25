package com.example.composeanimationsapp.screens.catGallery

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.collectAsLazyPagingItems
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.example.composeanimationsapp.components.BottomBar
import com.example.composeanimationsapp.screens.catGallery.mvi.CatGalleryViewModel

class CatGalleryScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<CatGalleryViewModel>()
        val state by viewModel.container.stateFlow.collectAsState()

        Log.v("alice", "state ${state.catData.collectAsLazyPagingItems()}")

        Scaffold(
            bottomBar = {
                BottomBar()
            }
        ) { paddingValues ->
            CatGalleryUI(padding = paddingValues)
        }
    }
}