package helper

import org.example.logic.models.AtmosphericDetails


fun createAtmosphericDetailsHelper(
    temperature: Double = 20.0,
    feelsLike: Double = 22.0,
     minTemperature: Double = 15.0,
     maxTemperature: Double= 30.0,
     humidity: Int = 20 ,
): AtmosphericDetails {
    return AtmosphericDetails(
        temperature = temperature,
        feelsLike = feelsLike,
        minTemperature = minTemperature,
        maxTemperature = maxTemperature,
        humidity = humidity
    )
}