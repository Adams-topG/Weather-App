package com.example.weatherapp.domain.model.apiModel

data class DayData(
    val dailyChanceOfRainData: Int?,
    val dailyChanceOfSnowData: Int?,
    val maxTempCData: Double?,
    val minTempCData: Double?,
    val totalSnowCmData: Double?
)