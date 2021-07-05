package com.mercy.kids.client.account.fragment

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mercy.kids.base.DataBindingFragment
import com.mercy.kids.client.R
import com.mercy.kids.client.databinding.FragmentFindEmailBinding
import com.mercy.kids.client.databinding.FragmentFindPasswordBinding
import com.mercy.kids.client.account.viewmodel.FindAccountViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

enum class FindAccountTabFragment(val position: Int) { FIND_EMAIL(0), FIND_PASSWORD(1) }

class FindAccountPagerAdapter @Inject constructor(
        activity: FragmentActivity
): FragmentStateAdapter(activity) {

    private val fragmentList = listOf(
            FindAccountTabFragment.FIND_EMAIL,
            FindAccountTabFragment.FIND_PASSWORD
    ).sortedBy { it.position }

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = when(fragmentList[position]) {
        FindAccountTabFragment.FIND_EMAIL -> FindEmailFragment().apply {

        }
        FindAccountTabFragment.FIND_PASSWORD -> FindPasswordFragment().apply {

        }
    }
}

@AndroidEntryPoint
class FindEmailFragment: DataBindingFragment<FragmentFindEmailBinding>() {
    override val layoutResId: Int = R.layout.fragment_find_email

    private val parentViewModel = activityViewModels<FindAccountViewModel>()

    override val bindingVariable: (FragmentFindEmailBinding) -> Unit = {
        binding.parentViewModel = parentViewModel.value
    }
}

@AndroidEntryPoint
class FindPasswordFragment: DataBindingFragment<FragmentFindPasswordBinding>() {
    override val layoutResId: Int = R.layout.fragment_find_password

    private val parentViewModel = activityViewModels<FindAccountViewModel>()

    override val bindingVariable: (FragmentFindPasswordBinding) -> Unit = {
        binding.parentViewModel = parentViewModel.value
    }
}