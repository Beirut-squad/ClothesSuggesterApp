package org.example.logic.usecases

import org.example.logic.models.Outfit
import org.example.logic.repositories.WeatherRepository

class SuggestOutfitUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun getOutfitBasedOnTemperature(): Outfit {
        TODO()
    }
}