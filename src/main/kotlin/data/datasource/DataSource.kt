package org.example.data.datasource

import org.example.data.dto.WeatherResponseDto

interface DataSource {
    suspend fun getWeatherData(city: String): WeatherResponseDto
}