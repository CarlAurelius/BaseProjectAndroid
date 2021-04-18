package com.base.project.view.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.base.project.databinding.FragmentSampleLoginBinding
import com.base.project.view.base.BaseFragment

class SampleLoginFragment : BaseFragment() {

    private val binding: FragmentSampleLoginBinding by viewBinding(CreateMethod.INFLATE)
    private val authViewModel: AuthViewModel by viewModels()

    override fun fragmentLayout(): View = binding.root

    override fun setup(savedInstanceState: Bundle?) {
    }
}