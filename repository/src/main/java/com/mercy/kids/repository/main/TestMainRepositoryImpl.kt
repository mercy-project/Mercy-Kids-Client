package com.mercy.kids.repository.main

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mercy.kids.remote.main.RecommendVideo
import com.mercy.kids.remote.main.RecommendVideoApiResult
import com.mercy.kids.repository.main.MainRepository
import com.mercy.kids.repository.main.RecommendPagingSource
import javax.inject.Inject

@VisibleForTesting
class TestMainRepositoryImpl @Inject constructor(

): MainRepository {

    override val recommendVideoFlow = Pager(PagingConfig(pageSize = 20)) {
        RecommendPagingSource(this)
    }.flow

    override suspend fun getRecommendVideoList(nextPageNumber: Int): RecommendVideoApiResult {
        return RecommendVideoApiResult(
            listOf(
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                ),
                RecommendVideo(
                    videoUrl = "https://youtu.be/lfsghY4sNlk?list=PLLoamEZ5bJuFxrpotAhDoXP_rdgQzgOqD",
                    title = "과거 코로나19에 감염되었던 사람(무증상, 증상 감염자)들도 백신 접종 대상인가요? [코로나19 백신 질문과 답변]",
                    channelThumbnailUrl = "https://yt3.ggpht.com/ytc/AKedOLRx1o4FfsK5isI9U-EHzAt7S57Knoyv7MoEIGKpGw=s176-c-k-c0x00ffffff-no-rj",
                    channelName = "대한민국 보건복지부",
                    views = 5433212,
                    uploadTime = System.currentTimeMillis()
                )
            ),
            null
        )
    }

}