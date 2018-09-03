package com.test.voicetubeapp.ui.countdown

import android.os.Bundle
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentCountdownBinding
import com.test.voicetubeapp.ui.base.BaseFragment

class CountdownFragment: BaseFragment<FragmentCountdownBinding, CountdownViewModel>() {

    companion object {
        fun newInstance(): CountdownFragment {
            val fragment = CountdownFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupView()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_countdown
    }

    override fun getViewModelClass(): Class<CountdownViewModel>? {
        return CountdownViewModel::class.java
    }

    private fun setupToolbar() {
        binding.toolbarContainer.toolbarTitleText.text = getString(R.string.countdown)
    }

    private fun setupView() {

    }

}