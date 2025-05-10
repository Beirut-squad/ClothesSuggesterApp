package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    val speed: Double?  = null,
    @SerialName("deg") val degree: Int? = null,
    val gust: Double? = null
)
