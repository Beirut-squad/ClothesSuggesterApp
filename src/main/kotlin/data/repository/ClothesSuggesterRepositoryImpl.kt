package data.repository

import org.example.data.repository.WeatherDataSource
import data.exception.NotFoundException
import data.exception.ServerErrorException
import data.exception.UnAuthorizedException
import data.mapper.toTemperature
import data.mapper.toWeatherData
import org.example.logic.models.extra_models.WeatherData
import logic.repository.ClothesSuggesterRepository
import org.example.data.repository.OutfitsDataSource
import org.example.logic.exceptions.WeatherServiceAuthenticationException
import org.example.logic.exceptions.CityNotFoundException
import org.example.logic.exceptions.UnexpectedWeatherException
import org.example.logic.exceptions.WeatherServiceException
import org.example.logic.models.basic_model.Temperature
import org.example.logic.models.extra_models.Outfit

class ClothesSuggesterRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
    private val outfitsDataSource: OutfitsDataSource
) : ClothesSuggesterRepository {

    override suspend fun getWeatherData(city: String): WeatherData {
        return try {
             weatherDataSource.getWeatherData(city).toWeatherData()
        } catch (e: Exception) {
            throw mapToDomainException(e, city)
        }
    }

    override suspend fun getTemperatureData(city: String): Temperature {
        return try {
            weatherDataSource.getAtmosphericDetails(city).toTemperature()
        } catch (e: Exception) {
            throw mapToDomainException(e, city)
        }
    }

    private fun mapToDomainException(e: Exception, city: String): Exception {
        return when (e) {
            is UnAuthorizedException ->
                WeatherServiceAuthenticationException("Authentication with weather service failed")

            is NotFoundException ->
                CityNotFoundException("No weather data for city $city")

            is ServerErrorException ->
                WeatherServiceException("Couldn't connect to server")

            else ->
                UnexpectedWeatherException("Unexpected error occurred")
        }
    }

    override fun getOutfits(): List<List<Outfit>> {
        return listOf(
            outfitsDataSource.getFreezingOutfits(),
            outfitsDataSource.getColdOutfits(),
            outfitsDataSource.getAverageOutfits(),
            outfitsDataSource.getWarmOutfits(),
            outfitsDataSource.getHotOutfits(),
            outfitsDataSource.getDeathOutfits()
        )
    }

}