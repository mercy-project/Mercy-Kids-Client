package com.mercy.kids.client.di.main

import com.mercy.kids.repository.main.MainRepository
import com.mercy.kids.repository.main.MainRepositoryImpl
import com.mercy.kids.repository.main.TestMainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MainRepositoryModule {

    @Binds
    abstract fun bindMainRepository(impl: TestMainRepositoryImpl): MainRepository

}

@Module
@InstallIn(ActivityRetainedComponent::class)
object MainApiModule {



}