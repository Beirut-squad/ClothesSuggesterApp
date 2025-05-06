package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    val speed: Double?,
    @SerialName("deg") val degree: Int?,
    val gust: Double? = null
)
