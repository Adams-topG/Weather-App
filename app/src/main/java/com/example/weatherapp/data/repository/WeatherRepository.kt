package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.domain.retrofit.RetrofitServices
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    suspend fun getWeather(city: String): Result<Weather?> {
        return try {
            val retrofit = retrofitServices.getWeather(city)
            if (retrofit.isSuccessful) {
                val res = Result.success(retrofit.body())
                if (res.getOrNull() == null)
                    Result.failure<Weather>(NullPointerException())
                else
                    res
            } else
                Result.failure(NullPointerException())
        } catch (ex: Throwable) {
            Result.failure<Weather?>(ex)
            throw ex
        }
    }

}