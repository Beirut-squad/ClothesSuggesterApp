package org.example.logic.usecase

import logic.repository.ClothesSuggesterRepository

class GetCurrentWeather(private val clothesSuggesterRepository: ClothesSuggesterRepository) {

    suspend fun getCurrentTemperature(city: String): Pair<String, String> {
        return Pair(
            clothesSuggesterRepository.getTemperatureData(city).temperature.toString(),
            clothesSuggesterRepository.getTemperatureData(city).feelsLike.toString()
        )
    }
}