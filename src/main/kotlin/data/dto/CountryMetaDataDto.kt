package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryMetaDataDto(
    val type: Int?,
    val id: Int?,
    val country: String?,
    @SerialName("sunrise") val sunriseTimestamp: Long?,
    @SerialName("sunset") val sunsetTimestamp: Long?
)