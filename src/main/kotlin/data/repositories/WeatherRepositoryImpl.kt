package org.example.data.repositories

import org.example.logic.models.WeatherData
import org.example.logic.repositories.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {

    override suspend fun getWeatherData(): WeatherData {
        TODO("Not yet implemented")
    }
}