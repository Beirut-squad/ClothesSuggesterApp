package data.helpers.model_helpers

import org.example.logic.models.Weather

fun createWeatherHelper(
    id: Int = 801,
    weatherState: String = "Clouds",
    description: String = "few clouds",
    ): Weather {
    return Weather(
        id = id,
        weatherState = weatherState,
        description = description
    )
}