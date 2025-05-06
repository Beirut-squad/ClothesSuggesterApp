package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsDto(
    @SerialName("all") val cloudsPercentage: Int? = null
)
