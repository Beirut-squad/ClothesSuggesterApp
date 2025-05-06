package org.example.data.datasource

import org.example.data.dto.WeatherResponseDto

interface DataSource {
    fun getWeatherData(city: String, language: String): WeatherResponseDto
}