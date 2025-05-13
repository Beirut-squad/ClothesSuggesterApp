package org.example.data.api

interface WeatherApiService {
    suspend fun getWeatherResponse(city: String) : String
}