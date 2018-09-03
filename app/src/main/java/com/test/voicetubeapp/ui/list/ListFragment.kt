package com.test.voicetubeapp.ui.list

import android.os.Bundle
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentListBinding
import com.test.voicetubeapp.ui.base.BaseFragment

class ListFragment: BaseFragment<FragmentListBinding, ListViewModel>() {

    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()
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
        return R.layout.fragment_list
    }

    override fun getViewModelClass(): Class<ListViewModel>? {
        return ListViewModel::class.java
    }

    private fun setupToolbar() {
        binding.toolbarContainer.toolbarTitleText.text = getString(R.string.list)
    }

    private fun setupView() {

    }

}