package com.example.weatherapp.di

import com.example.weatherapp.data.common.Common
import com.example.weatherapp.domain.retrofit.RetrofitServices
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder().addInterceptor(logger)
    private val moshi = Moshi.Builder() // adapter
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(): RetrofitServices =
        Retrofit.Builder()
            .baseUrl(Common.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client.build())
            .build()
            .create(RetrofitServices::class.java)

    @Provides
    @Singleton
    fun provideGson() : Gson = Gson()
}