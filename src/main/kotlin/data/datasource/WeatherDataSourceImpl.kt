package org.example.data.datasource

import kotlinx.serialization.json.Json
import org.example.data.dto.WeatherResponseDto
import org.example.data.api.WeatherApiService
import org.example.data.repository.WeatherDataSource

class WeatherDataSourceImpl(
    private val weatherApiService: WeatherApiService
) : WeatherDataSource {

    override suspend fun getWeatherData(
        city: String
    ): WeatherResponseDto {
        val response = weatherApiService.getWeatherResponse(city)

        return Json.decodeFromString<WeatherResponseDto>(response)
    }
}