package com.test.voicetubeapp.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.FragmentListBinding
import com.test.voicetubeapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast

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
        setupListener()
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

    private fun setupListener() {
        val onScrollListener = object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val layoutManager = recyclerView?.layoutManager as LinearLayoutManager
                if(dy > 0) {
                    val childCount = layoutManager.childCount
                    val itemCount = layoutManager.itemCount
                    val firstVisibleItemPosition= layoutManager.findFirstVisibleItemPosition()
                    if ((childCount + firstVisibleItemPosition) >= itemCount) {
                        setupData()
                    }
                }
            }
        }
        videoRecyclerView.addOnScrollListener(onScrollListener)
    }

    private fun observeData() {
        viewModel.videosLiveData.observe(this, Observer {
            for(i in 1..3) {
                listAdapter.setData(it!!)
            }
        })

        viewModel.toastLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setupData() {
        viewModel.fetchData()
    }

}