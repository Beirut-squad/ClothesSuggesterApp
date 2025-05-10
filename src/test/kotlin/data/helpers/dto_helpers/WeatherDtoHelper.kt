package data.helpers.dto_helpers

import org.example.data.dto.WeatherDto

fun createWeatherDtoHelper(
    id: Int = 801,
    weatherState: String = "Clouds",
    description: String = "few clouds",
    icon: String = "02n"
) : WeatherDto{
    return WeatherDto(
        id = id,
        weatherState = weatherState,
        description = description,
        icon = icon
    )
}