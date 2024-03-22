package com.example.composeanimationsapp.utils

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object Loading : SharedScreen()

    data object CatGallery : SharedScreen()
}