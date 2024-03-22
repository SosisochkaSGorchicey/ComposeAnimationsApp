package com.example.composeanimationsapp.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.composeanimationsapp.screens.loading.di.loadingScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            loadingScreenModule
        }

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(

                )
            )
        }
    }
}