package com.test.voicetubeapp.ui.setting

import android.os.Bundle
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentSettingBinding
import com.test.voicetubeapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    companion object {
        fun newInstance(): SettingFragment {
            val fragment = SettingFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var settingAdapter: SettingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupAdapter()
        setupData()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_setting
    }

    override fun getViewModelClass(): Class<SettingViewModel>? {
        return SettingViewModel::class.java
    }

    override fun onPause() {
        viewModel.storeSetting(settingAdapter.settingMap)
        super.onPause()
    }

    private fun setupToolbar() {
        binding.toolbarContainer.toolbarTitleText.text = getString(R.string.setting)
    }

    private fun setupAdapter() {
        settingAdapter = SettingAdapter()
        settingRecyclerView.setHasFixedSize(true)
        settingRecyclerView.adapter = settingAdapter
    }

    private fun setupData() {
        viewModel.initData()
        settingAdapter.setData(viewModel.settingMap, viewModel.settingList)
    }

}