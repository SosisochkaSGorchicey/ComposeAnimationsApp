package com.example.composeanimationsapp.screens.loading.mvi

import androidx.compose.runtime.Immutable

@Immutable
sealed interface LoadingEvent {
    data object Init : LoadingEvent
}

@Immutable
sealed interface LoadingSideEffect {
    data object NavigateToApp : LoadingSideEffect
}