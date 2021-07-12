package com.mercy.kids.client.main.usecase

import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.remote.main.RecommendVideo

object Mapper {

    fun toUiData(data: RecommendVideo): RecommendListRA.Data {
        return RecommendListRA.Data(
            videoId = data.videoId,
            videoUrl = data.videoUrl,
            title = data.title,
            metadata = "${data.channelName} | ${data.views}회 | ${data.uploadTime}",
            channelThumbnail = data.channelThumbnailUrl
        )
    }

}