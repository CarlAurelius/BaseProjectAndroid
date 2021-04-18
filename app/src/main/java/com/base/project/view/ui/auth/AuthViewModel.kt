package com.base.project.view.ui.auth

import androidx.lifecycle.SavedStateHandle
import com.base.project.data.repository.AuthRepository
import com.base.project.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repo: AuthRepository
) : BaseViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->

    }


}