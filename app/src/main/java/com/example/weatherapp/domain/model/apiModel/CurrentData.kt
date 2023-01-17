package com.example.weatherapp.domain.model.apiModel

data class CurrentData(
    val cloudData: Int?,
    val conditionData: ConditionData?,
    val conditionData2: ConditionData2,
    val conditionData3: ConditionData3,
    val feelsLikeCData: Double?,
    val humidityData: Int?,
    val isDayData: Int?,
    val pressureMbData: Double?,
    val tempCData: Double?,
    val windKphData: Double?
)