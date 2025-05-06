package data.helpers.dto_helpers

import org.example.data.dto.AtmosphericDetailsDto

fun createAtmosphericDetailsDtoHelper(
    temperature: Double = 26.42,
    feelsLike: Double = 26.42,
    minTemperature: Double = 26.42,
    maxTemperature: Double = 26.42,
    pressure: Int = 1017,
    humidity: Int = 29,
    seaLevel: Int = 1017,
    groundLevel: Int = 1012,
) : AtmosphericDetailsDto{
    return AtmosphericDetailsDto(
        temperature = temperature,
        feelsLike = feelsLike,
        minTemperature = minTemperature,
        maxTemperature = maxTemperature,
        pressure = pressure,
        humidity = humidity,
        seaLevel = seaLevel,
        groundLevel = groundLevel,
    )
}