package com.mercy.kids.client.di.main

import androidx.fragment.app.Fragment
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.client.main.adapter.RecommendVideoComparator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object TabRecommendComponentModule {

    @Provides
    fun providesRecyclerAdapter(fragment: Fragment): RecommendListRA {
        return RecommendListRA(RecommendVideoComparator)
    }

}