package org.example.data.datasource

import org.example.data.dto.WeatherResponseDto

interface WeatherDataSource {
    suspend fun getWeatherData(city: String): WeatherResponseDto
}