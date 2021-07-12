package com.mercy.kids.client.di

import android.app.Application
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.mercy.kids.component.video.VideoPlayer
import com.mercy.kids.component.video.VideoPlayerImpl
import com.mercy.kids.remote.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationModule {

    companion object {
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        }

        @Provides
        @Singleton
        fun provideVideoPlayer(application: Application): VideoPlayer {
            return VideoPlayerImpl(application.applicationContext)
        }
    }

}