package com.example.weatherapp.domain.model.apiModel

data class HourData(
    val chanceOfRainData: Int?,
    val chanceOfSnowData: Int?,
    val cloudData: Int?,
    val feelsLikeCData: Double?,
    val humidityData: Int?,
    val isDayData: Int?,
    val pressureMbData: Double?,
    val tempCData: Double?,
    val timeData: String?,
    val windKphData: Double?,
)