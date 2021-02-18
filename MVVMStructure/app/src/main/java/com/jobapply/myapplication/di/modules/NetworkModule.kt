package com.jobapply.myapplication.di.modules

import com.jobapply.myapplication.networkpack.NewsApi
import com.jobapply.myapplication.utils.Consts
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Reusable // What is Reusable code...
    @Provides
    internal fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logger).build()
    }

    @Reusable // What is Reusable code...
    @Provides
    internal fun provideRetrofitInterface(client: OkHttpClient) =
        Retrofit.Builder().baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    internal fun provideApi(retrofit: Retrofit) =
        retrofit.create(NewsApi::class.java)
}