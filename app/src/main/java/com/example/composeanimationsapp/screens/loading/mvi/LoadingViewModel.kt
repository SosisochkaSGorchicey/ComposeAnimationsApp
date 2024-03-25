package com.example.composeanimationsapp.screens.loading.mvi

import cafe.adriel.voyager.core.model.screenModelScope
import com.example.composeanimationsapp.utils.MviViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class LoadingViewModel : MviViewModel<Any, LoadingSideEffect, LoadingEvent>(
    initialState = Unit
) {
    init {
        onEvent(LoadingEvent.Init)
    }

    override fun onEvent(event: LoadingEvent) {
        when (event) {
            LoadingEvent.Init -> navigateToApp()
        }
    }

    private fun navigateToApp() = intent {
        screenModelScope.launch {
            delay(2000)
            postSideEffect(LoadingSideEffect.NavigateToApp)
        }
    }
}