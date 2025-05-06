package data.helpers.model_helpers

import org.example.logic.models.AtmosphericDetails


fun createAtmosphericDetailsHelper(
    temperature: Double = 26.42,
    feelsLike: Double = 26.42,
     minTemperature: Double = 26.42,
     maxTemperature: Double= 26.42,
     humidity: Int = 29 ,
): AtmosphericDetails {
    return AtmosphericDetails(
        temperature = temperature,
        feelsLike = feelsLike,
        minTemperature = minTemperature,
        maxTemperature = maxTemperature,
        humidity = humidity
    )
}