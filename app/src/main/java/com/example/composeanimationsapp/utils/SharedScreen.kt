package com.example.composeanimationsapp.utils

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object Loading : SharedScreen()
}