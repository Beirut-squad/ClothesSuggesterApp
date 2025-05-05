package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val id: Int?,
    @SerialName("main") val weatherState: String?,
    val description: String?,
    val icon: String?
)