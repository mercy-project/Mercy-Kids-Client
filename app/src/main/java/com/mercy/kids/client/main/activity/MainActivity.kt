package com.mercy.kids.client.main.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mercy.kids.base.component.DataBindingActivity
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivityMainBinding
import com.mercy.kids.client.main.fragment.VideoPlayerFragment
import com.mercy.kids.client.main.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(
    override val layoutResId: Int = R.layout.activity_main
): DataBindingActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var navController: NavController

    override val bindingVariable: (ActivityMainBinding) -> Unit = {
        it.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
        hideVideoPlayerFragment()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
    }

    private fun hideVideoPlayerFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.video_player_fragment_container) as VideoPlayerFragment
        supportFragmentManager.beginTransaction()
            .hide(fragment)
            .commit()
    }

}