package com.example.composeanimationsapp.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.composeanimationsapp.screens.catGallery.di.catGalleryScreenModule
import com.example.composeanimationsapp.screens.loading.di.LoadingModule
import com.example.composeanimationsapp.screens.loading.di.loadingScreenModule
import com.example.data.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            loadingScreenModule()
            catGalleryScreenModule()
        }

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(
                    LoadingModule(),
                    NetworkModule()
                )
            )
        }
    }
}