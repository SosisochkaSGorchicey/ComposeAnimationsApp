package com.example.data.di

import com.example.data.remote.datasource.NetworkService
import com.example.data.remote.repository.NetworkRepositoryImpl
import com.example.domain.CatDataPagingSource
import com.example.domain.repository.NetworkRepository
import com.example.domain.usecases.GetCatsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    operator fun invoke() = module {
        single { provideRetrofitForMyApp() }
        single { provideRecipesServiceForMyApp(retrofit = get()) }

        singleOf(::NetworkRepositoryImpl).bind(NetworkRepository::class)
        singleOf(::CatDataPagingSource)
        singleOf(::GetCatsUseCase)

    }

    private fun provideRetrofitForMyApp(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.thecatapi.com/v1/images/")
        .build()


    private fun provideRecipesServiceForMyApp(retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)

}