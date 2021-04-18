package com.base.project.di

import android.content.Context
import com.base.project.BaseApp
import com.base.project.data.local.AppDatabase
import com.base.project.data.local.SampleDao
import com.base.project.data.remote.APIService
import com.base.project.data.remote.RemoteDataSource
import com.base.project.data.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApp {
        return app as BaseApp
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) = AppDatabase.getDatabase(app)

    @Singleton
    @Provides
    fun provideSampleDao(db: AppDatabase) = db.sampleDao()


    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: APIService) = RemoteDataSource(apiService)


    @Singleton
    @Provides
    fun providesAuthRepository(remoteDataSource: RemoteDataSource, sampleDao: SampleDao) =
        AuthRepository(remoteDataSource, sampleDao)


}