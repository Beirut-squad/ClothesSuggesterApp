package org.example.logic.repositories

import org.example.logic.models.WeatherData
import org.intellij.lang.annotations.Language

interface WeatherRepository {
    suspend fun getWeatherData(name: String): WeatherData
}