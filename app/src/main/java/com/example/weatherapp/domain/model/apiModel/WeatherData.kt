package com.example.weatherapp.domain.model.apiModel

data class WeatherData(
    val currentData: CurrentData?,
    val forecastData: ForecastData?,
    val locationData: LocationData?
)