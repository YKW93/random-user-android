package com.wayne.randomuser.presentation.ui.main

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wayne.library.base.BaseFragment
import com.wayne.library.utils.CustomItemDecoration
import com.wayne.library.utils.EndlessRVScrollListener
import com.wayne.randomuser.R
import com.wayne.randomuser.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main),
    SwipeRefreshLayout.OnRefreshListener {

    private val viewModel: MainViewModel by viewModels()

    private val mainAdapter by lazy {
        MainAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        initUserListRV()
        initSwipeRefreshLayout()
    }

    override fun onRefresh() {
        mainAdapter.items.clear()
        viewModel.getUserList(0)
    }

    private fun initUserListRV() {
        binding.rvUserList.run {
            adapter = mainAdapter
            layoutManager?.let {
                addOnScrollListener(object : EndlessRVScrollListener(it, 10) {
                    override fun onLoadMore(page: Int) {
                        viewModel.getUserList(page)
                    }
                })
            }
            addItemDecoration(object : CustomItemDecoration() {
                override fun setSpacingForDirection(
                    outRect: Rect,
                    layoutManager: RecyclerView.LayoutManager?,
                    position: Int,
                    itemCount: Int
                ) {
                    outRect.top = if (position == 0) {
                        resources.getDimensionPixelSize(R.dimen.recyclerview_spacing_24dp)
                    } else {
                        resources.getDimensionPixelSize(R.dimen.recyclerview_spacing_12dp)
                    }

                    if (position == itemCount - 1) {
                        outRect.bottom =
                            resources.getDimensionPixelSize(R.dimen.recyclerview_spacing_12dp)
                    }
                }

            })
        }
    }

    private fun initSwipeRefreshLayout() {
        binding.srlUserList.setOnRefreshListener(this)
    }
}