package com.mercy.kids.client.main.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class VideoPlayerViewModel @ViewModelInject constructor(
    @Assisted val savedStateHandle: SavedStateHandle
): ViewModel() {
}