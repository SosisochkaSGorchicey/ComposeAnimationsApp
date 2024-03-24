package com.example.data.remote.datasource.model

import com.google.gson.annotations.SerializedName

data class CatData(
    @SerializedName("url")
    val imageUrl: String? = null
)
