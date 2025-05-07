package org.example.logic.repositories

import org.example.logic.models.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(city: String) : WeatherData
}