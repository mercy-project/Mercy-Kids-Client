package com.mercy.kids.repository.main

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mercy.kids.remote.main.RecommendVideo
import java.io.IOException

class RecommendPagingSource(
    private val repository: MainRepository
): PagingSource<Int, RecommendVideo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecommendVideo> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getRecommendVideoList(nextPage)
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = response.nextPageKey
            )
        } catch (e: Exception) {
            // handle errors
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RecommendVideo>): Int? {
        return state.anchorPosition?.let { pos ->
            val page = state.closestPageToPosition((pos))
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }

}