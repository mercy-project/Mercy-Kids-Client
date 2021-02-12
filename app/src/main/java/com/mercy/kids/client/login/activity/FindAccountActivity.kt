package com.mercy.kids.client.login.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mercy.kids.base.DataBindingActivity
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.ActivityFindAccountBinding
import com.mercy.kids.client.login.fragment.FindAccountPagerAdapter
import com.mercy.kids.client.login.fragment.FindAccountTabFragment
import com.mercy.kids.client.login.viewmodel.FindAccountViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FindAccountActivity(
        override val layoutResId: Int = R.layout.activity_find_account
) : DataBindingActivity<ActivityFindAccountBinding>(), TabLayoutMediator.TabConfigurationStrategy {

    private val viewModel by viewModels<FindAccountViewModel>()

    @Inject lateinit var adapter: FindAccountPagerAdapter

    override val bindingVariable: (ActivityFindAccountBinding) -> Unit = {
        it.viewModel = viewModel
        it.vpFindAccountContent.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TabLayoutMediator(binding.tlFindAccountTab, binding.vpFindAccountContent, this).attach()
        setToolbar(binding.tbFindAccount)
    }

    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
        when(position) {
            FindAccountTabFragment.FIND_EMAIL.position -> {
                tab.text = getString(R.string.find_account_email)
            }
            FindAccountTabFragment.FIND_PASSWORD.position -> {
                tab.text = getString(R.string.find_account_password)
            }
        }
    }

    override fun setToolbar(toolbar: Toolbar, homeIconRes: Int?) {
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }

}