package com.wayne.randomuser.presentation.ui.main

import android.os.Bundle
import com.wayne.library.base.BaseActivity
import com.wayne.randomuser.R
import com.wayne.randomuser.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}