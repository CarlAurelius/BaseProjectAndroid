package com.base.project.view.ui.auth

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.base.project.databinding.ActivitySampleAuthBinding
import com.base.project.view.base.BaseActivity

class SampleAuthActivity : BaseActivity() {

    private val binding: ActivitySampleAuthBinding by viewBinding(CreateMethod.INFLATE)

    override fun activityLayout(): View = binding.root

    override fun setup(savedInstanceState: Bundle?) {
    }
}