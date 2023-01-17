package com.example.weatherapp.domain.model.apiModel

data class ForecastdayData(
    val astroData: AstroData?,
    val dateData: String?,
    val dateEpochData: Int?,
    val dayData: DayData?,
    val hourData: List<HourData>?
)