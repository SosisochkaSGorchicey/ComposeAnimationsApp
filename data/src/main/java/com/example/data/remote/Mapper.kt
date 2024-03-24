package com.example.data.remote

import com.example.data.remote.datasource.model.CatData
import com.example.domain.model.Cat

fun List<CatData>.toDomain(): List<Cat> {
    return this.map { catData ->
        Cat(
            imageUrl = catData.imageUrl
        )
    }
}