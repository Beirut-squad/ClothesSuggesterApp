package org.example.data.repository

import org.example.data.dto.WeatherResponseDto

interface WeatherDataSource {
    suspend fun getWeatherData(city: String): WeatherResponseDto
}