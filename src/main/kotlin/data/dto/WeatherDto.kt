package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val id: Int? = null,
    @SerialName("main") val weatherState: String? = null,
    val description: String? = null,
    val icon: String? = null
)