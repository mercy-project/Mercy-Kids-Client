package com.mercy.kids.remote.main

data class RecommendVideoApiResult(
    val data: List<RecommendVideo>,
    val nextPageKey: Int? = null
)

data class RecommendVideo(
    val videoUrl: String,
    val title: String,
    val channelThumbnailUrl: String,
    val channelName: String,
    val views: Long,
    val uploadTime: Long
)