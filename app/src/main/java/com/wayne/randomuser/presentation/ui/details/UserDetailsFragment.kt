package com.wayne.randomuser.presentation.ui.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.wayne.library.base.BaseFragment
import com.wayne.randomuser.R
import com.wayne.randomuser.databinding.FragmentUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding, UserDetailsViewModel>(
    R.layout.fragment_user_details,
    UserDetailsViewModel::class
) {

    override val navArgs: UserDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}