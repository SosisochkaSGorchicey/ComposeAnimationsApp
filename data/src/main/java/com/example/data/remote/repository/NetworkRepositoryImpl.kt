package com.example.data.remote.repository

import com.example.data.remote.datasource.NetworkService
import com.example.data.remote.toDomain
import com.example.domain.model.Cat
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val networkService: NetworkService
) : NetworkRepository {
    override suspend fun getListOfCats(page: Int): List<Cat> =
        networkService.getListOfCats(page = page).toDomain()
}