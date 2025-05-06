package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesDto(
    @SerialName("lon") val longitude: Double?,
    @SerialName("lat") val latitude: Double?
)
