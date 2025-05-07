package org.example.data.repositories

import org.example.logic.models.WeatherData
import org.example.logic.repositories.WeatherRepository
import org.intellij.lang.annotations.Language

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getWeatherData(city: String): WeatherData {
        TODO("Not yet implemented")
    }
}