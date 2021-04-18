package com.base.project.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger

abstract class BaseFragment : Fragment(), AnkoLogger {

    protected lateinit var baseAct: BaseActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return fragmentLayout()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseAct = requireActivity() as BaseActivity


        setup(savedInstanceState)
    }

    abstract fun fragmentLayout(): View
    abstract fun setup(savedInstanceState: Bundle?)
}