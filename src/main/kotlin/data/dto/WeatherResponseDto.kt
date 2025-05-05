package org.example.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponseDto(
    @SerialName("coord")val coordinatesDto: CoordinatesDto?,
    @SerialName("weather") val weathers: List<WeatherDto>?,
    val base: String?,
    @SerialName("main") val atmosphericDataDto: AtmosphericDetailsDto?,
    val visibility: Int?,
    @SerialName("wind") val windDto: WindDto?,
    @SerialName("clouds") val cloudsDto: CloudsDto?,
    @SerialName("dt")val timeOfResponse: Long?,
    @SerialName("sys")val countryMetaDataDto: CountryMetaDataDto?,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    @SerialName("cod")val httpResponseCode: Int?
)

