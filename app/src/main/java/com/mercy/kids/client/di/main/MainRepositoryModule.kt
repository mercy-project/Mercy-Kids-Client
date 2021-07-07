package com.mercy.kids.client.di.main

import com.mercy.kids.repository.main.MainRepository
import com.mercy.kids.repository.main.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MainRepositoryModule {

    @Binds
    abstract fun bindMainRepository(impl: MainRepositoryImpl): MainRepository

}

@Module
@InstallIn(ActivityRetainedComponent::class)
object MainApiModule {



}