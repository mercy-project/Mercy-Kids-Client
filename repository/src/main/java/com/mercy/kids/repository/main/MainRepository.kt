package com.mercy.kids.repository.main

import androidx.paging.PagingData
import com.mercy.kids.remote.main.RecommendVideo
import com.mercy.kids.remote.main.RecommendVideoApiResult
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    val recommendVideoFlow: Flow<PagingData<RecommendVideo>>

    suspend fun getRecommendVideoList(nextPageNumber: Int): RecommendVideoApiResult

}