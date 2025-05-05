package org.example.data.mappers

import org.example.data.dto.*
import org.example.logic.models.*


fun WeatherResponseDto.toWeatherData(): WeatherData {
    return WeatherData(
        weather = this.weathers?.map { it.toWeather() },
        base = this.base,
        atmosphericData = this.atmosphericDataDto?.toAtmosphericDetails(),
        visibility = this.visibility,
        wind = this.windDto?.toWind(),
        clouds = this.cloudsDto?.toClouds(),
        timeOfResponse = this.timeOfResponse,
        timezone = this.timezone,
        id = this.id,
        name = this.name,
        httpResponseCode = this.httpResponseCode
    )
}

fun AtmosphericDetailsDto.toAtmosphericDetails(): AtmosphericDetails {
    return AtmosphericDetails(
        temperature = this.temperature,
        feelsLike = this.feelsLike,
        minTemperature = this.minTemperature,
        maxTemperature = this.maxTemperature,
        humidity = this.humidity
    )
}

fun CloudsDto.toClouds(): Clouds {
    return Clouds(
        cloudsPercentage = this.cloudsPercentage,
    )

}

fun WeatherDto.toWeather(): Weather {
    return Weather(
        id = this.id,
        weatherState = this.weatherState,
        description = this.description,
    )
}

fun WindDto.toWind(): Wind {
    return Wind(
        speed = this.speed,
        degree = this.degree
    )
}
    
