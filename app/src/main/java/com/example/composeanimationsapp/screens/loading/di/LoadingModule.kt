package com.example.composeanimationsapp.screens.loading.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.composeanimationsapp.screens.loading.LoadingScreen
import com.example.composeanimationsapp.screens.loading.mvi.LoadingViewModel
import com.example.composeanimationsapp.utils.SharedScreen
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object LoadingModule {
    operator fun invoke() = module {
        factoryOf(::LoadingViewModel)
    }
}

val loadingScreenModule = screenModule {
    register<SharedScreen.Loading> {
        LoadingScreen()
    }
}