package com.mercy.kids.client.main.fragment

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mercy.kids.base.component.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.LayoutMainVideoPlayerBinding
import com.mercy.kids.client.main.viewmodel.MainActivityViewModel
import com.mercy.kids.client.main.viewmodel.VideoPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoPlayerFragment(
    override val layoutResId: Int = R.layout.layout_main_video_player
): DataBindingFragment<LayoutMainVideoPlayerBinding>() {

    private val activityViewModel: MainActivityViewModel by activityViewModels()
    private val viewModel: VideoPlayerViewModel by viewModels()

    override val bindingVariable: (LayoutMainVideoPlayerBinding) -> Unit = {
        it.viewModel = viewModel
        binding.playerMotionLayout.setTransitionListener(transitionListener)
    }
    
    private val transitionListener = object: MotionLayout.TransitionListener {
        override fun onTransitionStarted(layout: MotionLayout?, startId: Int, endId: Int) = Unit

        override fun onTransitionChange(layout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
            activityViewModel.setMotionLayoutProgress(progress)
        }

        override fun onTransitionCompleted(layout: MotionLayout?, p1: Int) = Unit

        override fun onTransitionTrigger(layout: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit
    }

}