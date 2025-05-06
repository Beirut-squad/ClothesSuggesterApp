package org.example.logic.models

data class WeatherData(
    val weather: List<Weather>?,
    val base: String?,
    val atmosphericData: AtmosphericDetails?,
    val visibility: Int?,
    val wind: Wind?,
    val clouds: Clouds?,
    val timeOfResponse: Long?,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    val httpResponseCode: Int?
)
