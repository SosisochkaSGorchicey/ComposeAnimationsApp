package com.example.data.remote.datasource

import com.example.data.BuildConfig
import com.example.data.remote.datasource.model.CatData
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("search")
    suspend fun getListOfCats(
        @Query("api_key")
        apiKey: String = BuildConfig.catApiKey,

        @Query("limit")
        limit: String = "10",

        @Query("page")
        page: Int
    ): List<CatData>
}
