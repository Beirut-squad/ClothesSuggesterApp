package org.example.data.repositories

import org.example.data.datasource.DataSource
import org.example.data.mappers.toWeatherData
import org.example.logic.models.WeatherData
import org.example.logic.repositories.WeatherRepository

class WeatherRepositoryImpl(
    val dataSource: DataSource
) : WeatherRepository {

    override suspend fun getWeatherData(city: String, language: String): WeatherData {
        val weatherData = dataSource.getWeatherData(city = city, language = language)

        return weatherData.toWeatherData()
    }
}