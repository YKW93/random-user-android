package com.wayne.randomuser.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.wayne.library.base.BaseFragment
import com.wayne.randomuser.R
import com.wayne.randomuser.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}