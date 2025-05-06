package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesDto(
    @SerialName("lon") val longitude: Double?  = null,
    @SerialName("lat") val latitude: Double?  = null,
)
