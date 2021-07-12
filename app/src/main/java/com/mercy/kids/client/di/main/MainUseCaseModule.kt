package com.mercy.kids.client.di.main

import android.app.Activity
import com.mercy.kids.client.main.activity.MainActivity
import com.mercy.kids.client.main.usecase.MainActivityUseCase
import com.mercy.kids.component.video.VideoViewHolder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainUseCaseModule {

    @Provides
    fun provideMainActivityUseCase(activity: Activity): MainActivityUseCase {
        return if(activity is MainActivity) {
            MainActivityUseCase(activity)
        } else throw ClassCastException("wrong activity")
    }

    @Provides
    fun providesVideoVHAction(activity: Activity): VideoViewHolder.Action {
        return if(activity is MainActivity) {
            activity
        } else throw ClassCastException("wrong activity")
    }
}