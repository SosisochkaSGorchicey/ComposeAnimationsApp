package com.example.domain.repository

import com.example.domain.model.Cat

interface NetworkRepository {
    suspend fun getListOfCats(page: Int): List<Cat>
}