package org.example.logic.usecases

import org.example.logic.exceptions.WeatherDataNotFoundException
import org.example.logic.helper.*
import org.example.logic.models.*
import org.example.logic.repositories.WeatherRepository
import org.intellij.lang.annotations.Language

class SuggestOutfitUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun getOutfitBasedOnTemperature(city : String): Outfit {
        val weatherData = weatherRepository.getWeatherData(city)
        if (checkIfNull(weatherData))
            throw WeatherDataNotFoundException(" weather data not found")

        return getRandomOutfitBasedOnTemp(weatherData)
    }

    private fun checkIfNull(weatherData: WeatherData): Boolean {
        return weatherData.atmosphericData?.temperature == null ||
                weatherData.atmosphericData.feelsLike == null
    }

    private fun getRandomOutfitBasedOnTemp(weatherData: WeatherData): Outfit {
        val temp = weatherData.atmosphericData!!.temperature
        val feelsLike = weatherData.atmosphericData.feelsLike
        val avgTemp = (temp!! + feelsLike!!) / 2
        val outfits = getOutfitsBasedOnTemperature(avgTemp)
        return outfits.shuffled().first()
    }

    private fun getOutfitsBasedOnTemperature(temp: Double): List<Outfit> {
        return when (temp) {
            in -50.0..7.0 -> outfitsBasedOnWeather.freezingOutfits
            in 7.1..13.0 -> outfitsBasedOnWeather.coldOutfits
            in 13.1..18.0 -> outfitsBasedOnWeather.averageOutfits
            in 18.1..26.0 -> outfitsBasedOnWeather.warmOutfits
            in 26.1..50.0 -> outfitsBasedOnWeather.hotOutfits
            else -> outfitsBasedOnWeather.deathOutfits
        }
    }
}