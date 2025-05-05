package org.example.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherResponseDto(
    @SerialName("coord")val coordinatesDto: CoordinatesDto?,
    val weather: List<WeatherDto>?,
    val base: String?,
    @SerialName("main") val atmosphericData: AtmosphericDetailsDto?,
    val visibility: Int?,
    val windDto: WindDto?,
    val clouds: CloudsDto?,
    @SerialName("dt")val timeOfResponse: Long?,
    @SerialName("Sys")val countryMetaDataDto: CountryMetaDataDto?,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    @SerialName("cod")val httpResponseCode: Int?
)

