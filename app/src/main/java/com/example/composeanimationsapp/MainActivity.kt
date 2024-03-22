package com.example.composeanimationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.example.composeanimationsapp.ui.theme.ComposeAnimationsAppTheme
import com.example.composeanimationsapp.utils.SharedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationsAppTheme {
                val loadingScreen = rememberScreen(provider = SharedScreen.Loading)
                Navigator(screen = loadingScreen)
            }
        }
    }
}