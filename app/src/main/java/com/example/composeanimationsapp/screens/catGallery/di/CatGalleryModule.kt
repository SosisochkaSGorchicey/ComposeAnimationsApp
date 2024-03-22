package com.example.composeanimationsapp.screens.catGallery.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.composeanimationsapp.screens.catGallery.CatGalleryScreen
import com.example.composeanimationsapp.utils.SharedScreen

object CatGalleryModule {
}

val catGalleryScreenModule = screenModule {
    register<SharedScreen.CatGallery> {
        CatGalleryScreen()
    }
}