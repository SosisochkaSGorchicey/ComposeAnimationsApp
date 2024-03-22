package com.example.composeanimationsapp.screens.loading

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.composeanimationsapp.screens.loading.mvi.LoadingSideEffect
import com.example.composeanimationsapp.screens.loading.mvi.LoadingViewModel
import com.example.composeanimationsapp.utils.SharedScreen

class LoadingScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<LoadingViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        val catGalleryScreen = rememberScreen(provider = SharedScreen.CatGallery)

        LaunchedEffect(key1 = viewModel) {
            viewModel.container.sideEffectFlow.collect { sideEffect ->
                when (sideEffect) {
                    LoadingSideEffect.NavigateToApp -> navigator.replace(catGalleryScreen)
                }
            }
        }

        LoadingScreenUi()
    }
}