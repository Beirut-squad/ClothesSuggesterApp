package logic.usecase

import org.example.logic.exceptions.WeatherDataNotFoundException
import org.example.logic.models.*
import logic.repository.ClothesSuggesterRepository
import org.example.logic.utils.OutfitIndex

class SuggestOutfitUseCase(private val clothesSuggesterRepository: ClothesSuggesterRepository) {

    suspend fun getOutfitBasedOnTemperature(city : String): Outfit {
        val weatherData = clothesSuggesterRepository.getWeatherData(city)
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
            in -50.0..7.0 -> clothesSuggesterRepository.getOutfits()[OutfitIndex.FREEZING_OUTFIT]
            in 7.1..13.0 -> clothesSuggesterRepository.getOutfits()[OutfitIndex.COLD_OUTFIT]
            in 13.1..18.0 -> clothesSuggesterRepository.getOutfits()[OutfitIndex.AVERAGE_OUTFIT]
            in 18.1..26.0 -> clothesSuggesterRepository.getOutfits()[OutfitIndex.WARM_OUTFIT]
            in 26.1..50.0 -> clothesSuggesterRepository.getOutfits()[OutfitIndex.HOT_OUTFIT]
            else -> clothesSuggesterRepository.getOutfits()[OutfitIndex.OTHER_OUTFITS]
        }
    }
}