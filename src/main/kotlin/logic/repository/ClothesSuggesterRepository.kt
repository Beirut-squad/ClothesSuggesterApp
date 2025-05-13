package logic.repository

import org.example.logic.models.Outfit
import org.example.logic.models.WeatherData

interface ClothesSuggesterRepository {
    suspend fun getWeatherData(city: String): WeatherData
    fun getOutfits(): List<List<Outfit>>
}