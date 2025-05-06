package org.example.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponseDto(
    @SerialName("coord")val coordinatesDto: CoordinatesDto? = null,
    @SerialName("weather") val weathers: List<WeatherDto>? = null,
    val base: String? = null,
    @SerialName("main") val atmosphericDataDto: AtmosphericDetailsDto? = null,
    val visibility: Int? = null,
    @SerialName("wind") val windDto: WindDto? = null,
    @SerialName("clouds") val cloudsDto: CloudsDto? = null,
    @SerialName("dt")val timeOfResponse: Long? = null,
    @SerialName("sys")val countryMetaDataDto: CountryMetaDataDto? = null,
    val timezone: Int? = null,
    val id: Int? = null,
    val name: String? = null,
    @SerialName("cod")val httpResponseCode: Int?  = null
)

