package com.base.project.di

import com.base.project.data.remote.APIService
import com.orhanobut.hawk.Hawk
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import com.base.project.BuildConfig


private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L
const val TOKEN = "BearerToken"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideTrendingService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .build()

    @Provides
    fun providesOkHttp(
        @Named("logsInterceptor") logsInterceptor: HttpLoggingInterceptor,
        @Named("tokenInterceptor") tokenInterceptor: Interceptor
    ): OkHttpClient {

        val builder = OkHttpClient.Builder()
        builder.connectTimeout(1, TimeUnit.MINUTES)
        builder.writeTimeout(1, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)
        builder.addInterceptor(tokenInterceptor)
        builder.retryOnConnectionFailure(false)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(logsInterceptor)
        }

        return builder.build()
    }


    @Provides
    @Named("tokenInterceptor")
    fun provideTokenInterceptor(): Interceptor = Interceptor { chain ->

        val requestChain = chain.request().newBuilder()
            .build()


        chain.proceed(requestChain)
    }

    @Provides
    @Named("logsInterceptor")
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return logInterceptor
    }


}