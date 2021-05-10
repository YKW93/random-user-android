package com.wayne.randomuser.presentation.ui.main

import android.os.Bundle
import com.wayne.library.base.BaseActivity
import com.wayne.library.base.BaseViewModel
import com.wayne.randomuser.R
import com.wayne.randomuser.databinding.ActivityMainBinding
import com.wayne.randomuser.presentation.base.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, EmptyViewModel>(
    R.layout.activity_main,
    EmptyViewModel::class
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}