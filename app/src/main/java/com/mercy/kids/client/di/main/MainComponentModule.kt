package com.mercy.kids.client.di.main

import androidx.fragment.app.Fragment
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.client.main.adapter.RecommendVideoComparator
import com.mercy.kids.client.main.fragment.TabRecommendFragment
import com.mercy.kids.component.video.VideoViewHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object TabRecommendComponentModule {

    @Provides
    fun provideRecommendListRA(videoAction: VideoViewHolder.Action, fragment: Fragment): RecommendListRA {
        if(fragment is TabRecommendFragment) {
            return RecommendListRA(RecommendVideoComparator, videoAction, fragment)
        } else throw IllegalStateException("wrong fragment")
    }

}