package org.example.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponseDto(
    @SerialName("coord") val coordinatesDto: CoordinatesDto? = null,
    @SerialName("weather") val weathers: List<WeatherDto>? = null,
    @SerialName("base") val base: String? = null,
    @SerialName("main") val atmosphericDataDto: AtmosphericDetailsDto? = null,
    @SerialName("visibility") val visibility: Int? = null,
    @SerialName("wind") val windDto: WindDto? = null,
    @SerialName("clouds") val cloudsDto: CloudsDto? = null,
    @SerialName("dt") val timeOfResponse: Long? = null,
    @SerialName("sys") val countryMetaDataDto: CountryMetaDataDto? = null,
    @SerialName("timezone") val timezone: Int? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("cod") val httpResponseCode: Int? = null
)

