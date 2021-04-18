package com.base.project.data.repository

import com.base.project.data.local.SampleDao
import com.base.project.data.remote.RemoteDataSource
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val tpcRemoteDataSource: RemoteDataSource,
    private val profileDao: SampleDao
) {
}