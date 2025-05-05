package org.example.data.datasource

import org.example.data.dto.WeatherResponseDto

interface DataSource {
    fun getWeatherResponse(): WeatherResponseDto
}