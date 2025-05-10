package data.repository

import org.example.data.datasource.DataSource
import data.exception.NotFoundException
import data.exception.ServerErrorException
import data.exception.UnAuthorizedException
import data.mapper.toWeatherData
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