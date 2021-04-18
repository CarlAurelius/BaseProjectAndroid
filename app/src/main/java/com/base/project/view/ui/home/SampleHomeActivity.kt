package com.base.project.view.ui.home

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.base.project.databinding.ActivitySampleHomeBinding
import com.base.project.view.base.BaseActivity

class SampleHomeActivity : BaseActivity() {

    private val binding: ActivitySampleHomeBinding by viewBinding(CreateMethod.INFLATE)

    override fun activityLayout(): View = binding.root

    override fun setup(savedInstanceState: Bundle?) {
    }
}