package com.test.voicetubeapp.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentListBinding
import com.test.voicetubeapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: BaseFragment<FragmentListBinding, ListViewModel>() {

    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var listAdapter: ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupAdapter()
        observeData()
        setupData()
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

    private fun setupAdapter() {
        listAdapter = ListAdapter()
        videoRecyclerView.setHasFixedSize(true)
        videoRecyclerView.adapter = listAdapter
    }

    private fun observeData() {
        viewModel.videosLiveData.observe(this, Observer {
            listAdapter.setData(it!!)
        })
    }

    private fun setupData() {
        viewModel.fetchData()
    }

}