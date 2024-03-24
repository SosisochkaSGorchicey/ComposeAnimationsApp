package com.example.composeanimationsapp.screens.catGallery

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.composeanimationsapp.components.BottomBar

class CatGalleryScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            bottomBar = {
                BottomBar()
            }
        ) { paddingValues ->
            CatGalleryUI(padding = paddingValues)
        }
    }
}