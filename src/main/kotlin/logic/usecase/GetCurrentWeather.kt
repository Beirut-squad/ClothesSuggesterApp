package org.example.logic.usecase

import logic.repository.ClothesSuggesterRepository

class GetCurrentWeather(val clothesSuggesterRepository: ClothesSuggesterRepository){

    suspend fun getCurrentTemperature(city: String): String{
        return clothesSuggesterRepository.getWeatherData(city).atmosphericData!!.temperature.toString()
    }
}