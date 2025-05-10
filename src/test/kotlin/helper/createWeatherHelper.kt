package helper

import org.example.logic.models.Weather
import org.junit.runner.Description

fun createWeatherHelper(
    id: Int = 20,
    weatherState: String = "sunny",
    description: String = "no",
    ): Weather {
    return Weather(
        id = id,
        weatherState = weatherState,
        description = description
    )
}