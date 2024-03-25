package com.example.composeanimationsapp.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.composeanimationsapp.screens.catGallery.CatGalleryScreen
import com.example.composeanimationsapp.screens.catGallery.mvi.CatGalleryViewModel
import com.example.composeanimationsapp.screens.loading.LoadingScreen
import com.example.composeanimationsapp.screens.loading.mvi.LoadingViewModel
import com.example.composeanimationsapp.utils.SharedScreen
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object PresentationModule {
    operator fun invoke() = module {
        factoryOf(::LoadingViewModel)
        factoryOf(::CatGalleryViewModel)
    }
}

val screensScreenModule = screenModule {
    register<SharedScreen.CatGallery> {
        CatGalleryScreen()
    }

    register<SharedScreen.Loading> {
        LoadingScreen()
    }
}