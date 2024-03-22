package com.example.composeanimationsapp.screens.loading.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.composeanimationsapp.screens.loading.LoadingScreen
import com.example.composeanimationsapp.utils.SharedScreen

object LoadingModule {
}

val loadingScreenModule = screenModule {
    register<SharedScreen.Loading> {
        LoadingScreen()
    }
}