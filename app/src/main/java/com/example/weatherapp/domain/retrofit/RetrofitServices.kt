package com.example.weatherapp.domain.retrofit

import com.example.weatherapp.data.common.Common
import com.example.weatherapp.data.model.Weather

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("forecast.json")
    suspend fun getWeather(@Query("q")city:String,
                   @Query("days")days:Int = 3,
                   @Query("key")key : String = Common.KEY) : Response<Weather>
}