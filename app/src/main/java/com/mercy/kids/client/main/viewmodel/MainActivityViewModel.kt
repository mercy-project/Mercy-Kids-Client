package com.mercy.kids.client.main.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.mercy.kids.base.BaseViewModel
import com.mercy.kids.base.extension.safeValue
import com.mercy.kids.client.main.adapter.RecommendListRA
import com.mercy.kids.client.main.usecase.MainActivityUseCase
import com.mercy.kids.client.main.usecase.Mapper
import com.mercy.kids.component.video.VideoViewHolder
import com.mercy.kids.remote.main.RecommendVideo
import com.mercy.kids.repository.main.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainActivityViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    useCase: MainActivityUseCase,
    @Assisted val savedStateHandle: SavedStateHandle
): BaseViewModel<MainActivityUseCase>(useCase) {

    private val _motionLayoutProgress = MutableLiveData<Float>()

    val motionLayoutProgress: LiveData<Float> = _motionLayoutProgress

    val recommendVideoData: Flow<PagingData<RecommendListRA.Data>> get() =
        repository.recommendVideoFlow
            .cachedIn(viewModelScope)
            .map { data ->
                data.map { Mapper.toUiData(it) }
            }

    fun setMotionLayoutProgress(progress: Float) {
        _motionLayoutProgress.safeValue = progress
    }

    fun saveVideoDataIntoStorage(data: VideoViewHolder.VideoData) {

    }

    fun deleteVideoData(data: VideoViewHolder.VideoData) {

    }

}