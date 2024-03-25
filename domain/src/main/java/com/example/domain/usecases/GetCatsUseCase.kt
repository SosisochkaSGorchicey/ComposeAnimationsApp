package com.example.domain.usecases

import com.example.domain.CatDataPagingSource

class GetCatsUseCase(
    private val catDataPagingSource: CatDataPagingSource
) {
    operator fun invoke() = catDataPagingSource
}