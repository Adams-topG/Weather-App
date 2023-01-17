package com.example.weatherapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "current")
    val current: Current?,
    @Json(name = "forecast")
    val forecast: Forecast?,
    @Json(name = "location")
    val location: Location?
)