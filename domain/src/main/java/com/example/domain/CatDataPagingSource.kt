package com.example.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.Cat
import com.example.domain.repository.NetworkRepository
import java.io.IOException

class CatDataPagingSource(
    private val networkRepository: NetworkRepository
) : PagingSource<Int, Cat>() {

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        return try {
            val page = params.key ?: 0
            val pageSize = params.loadSize.coerceAtMost(10)

            val response = networkRepository.getListOfCats(page = page)

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.size > pageSize) null else page + 1

            LoadResult.Page(data = response, prevKey = prevKey, nextKey = nextKey)

        } catch (exception: IOException) {
            LoadResult.Error(exception)

        } catch (exception: Exception) {
            LoadResult.Error(exception)

        }
    }
}
