package com.test.voicetubeapp.ui.setting

import android.os.Bundle
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentSettingBinding
import com.test.voicetubeapp.ui.base.BaseFragment

class SettingFragment: BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    companion object {
        fun newInstance(): SettingFragment {
            val fragment = SettingFragment()
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
        return R.layout.fragment_setting
    }

    override fun getViewModelClass(): Class<SettingViewModel>? {
        return SettingViewModel::class.java
    }

    private fun setupToolbar() {
        binding.toolbarContainer.toolbarTitleText.text = getString(R.string.setting)
    }

    private fun setupView() {

    }

}