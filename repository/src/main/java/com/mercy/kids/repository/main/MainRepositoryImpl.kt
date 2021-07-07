package com.mercy.kids.repository.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mercy.kids.remote.main.RecommendVideo
import com.mercy.kids.remote.main.RecommendVideoApiResult
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(

): MainRepository {

    override val recommendVideoFlow = Pager(PagingConfig(pageSize = 20)) {
        RecommendPagingSource(this)
    }.flow

    override suspend fun getRecommendVideoList(nextPageNumber: Int): RecommendVideoApiResult {
        return RecommendVideoApiResult(
            listOf(),
            null
        )
    }

}