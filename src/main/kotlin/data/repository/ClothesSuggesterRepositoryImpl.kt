package data.repository

import org.example.data.repository.WeatherDataSource
import data.exception.NotFoundException
import data.exception.ServerErrorException
import data.exception.UnAuthorizedException
import data.mapper.toWeatherData
import org.example.logic.models.WeatherData
import logic.repository.ClothesSuggesterRepository
import org.example.data.repository.OutfitsDataSource
import org.example.logic.exceptions.WeatherServiceAuthenticationException
import org.example.logic.exceptions.CityNotFoundException
import org.example.logic.exceptions.UnexpectedWeatherException
import org.example.logic.exceptions.WeatherServiceException
import org.example.logic.models.Outfit

class ClothesSuggesterRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
    private val outfitsDataSource: OutfitsDataSource
) : ClothesSuggesterRepository {

    override suspend fun getWeatherData(city: String): WeatherData {
        try {
            val weatherData = weatherDataSource.getWeatherData(city = city)
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