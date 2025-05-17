package logic.repository

import org.example.logic.models.basic_model.Temperature
import org.example.logic.models.extra_models.Outfit
import org.example.logic.models.extra_models.WeatherData

interface ClothesSuggesterRepository {
    suspend fun getWeatherData(city: String): WeatherData

    suspend fun getTemperatureData(city: String): Temperature
    fun getOutfits(): List<List<Outfit>>
}