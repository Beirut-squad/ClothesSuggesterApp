package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AtmosphericDetailsDto(
    @SerialName("temp") val temperature: Double?,
    @SerialName("feels_like") val feelsLike: Double?,
    @SerialName("temp_min") val minTemperature: Double?,
    @SerialName("temp_max") val maxTemperature: Double?,
    val pressure: Int?,
    val humidity: Int?,
    @SerialName("sea_level") val seaLevel: Int?,
    @SerialName("grnd_level") val groundLevel: Int?
)
