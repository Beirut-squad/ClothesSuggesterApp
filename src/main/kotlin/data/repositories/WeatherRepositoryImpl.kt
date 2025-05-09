package org.example.data.repositories

import org.example.data.datasource.DataSource
import org.example.data.exceptions.NotFoundException
import org.example.data.exceptions.ServerErrorException
import org.example.data.exceptions.UnAuthorizedException
import org.example.data.mappers.toWeatherData
import org.example.logic.models.WeatherData
import org.example.logic.repositories.WeatherRepository
import org.example.logic.exceptions.WeatherServiceAuthenticationException
import org.example.logic.exceptions.CityNotFoundException
import org.example.logic.exceptions.UnexpectedWeatherException
import org.example.logic.exceptions.WeatherServiceException

class WeatherRepositoryImpl(
    private val dataSource: DataSource
) : WeatherRepository {

    override suspend fun getWeatherData(city: String): WeatherData {
        try {
            val weatherData = dataSource.getWeatherData(city = city)
            return weatherData.toWeatherData()
        } catch (e: Exception) {
            when (e) {
                is UnAuthorizedException ->
                    throw WeatherServiceAuthenticationException("Authentication with weather service failed")

                is NotFoundException ->
                    throw CityNotFoundException("No weather data for city $city")

                is ServerErrorException ->
                    throw WeatherServiceException("Couldn't connect to server")

                else ->
                    throw UnexpectedWeatherException("Unexpected error occurred")
            }
        }
    }
}