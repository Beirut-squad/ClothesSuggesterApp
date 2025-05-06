package org.example.data.datasource

import org.example.data.dto.WeatherResponseDto

class ApiDataSourceImpl : DataSource {

    override suspend fun getWeatherData(
        city: String,
        language: String
    ): WeatherResponseDto {
        TODO("Not yet implemented")
    }

}