package logic.repository

import org.example.logic.models.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(city: String): WeatherData
}