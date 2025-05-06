package org.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryMetaDataDto(
    @SerialName("type") val type: Int? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("country")val country: String? = null,
    @SerialName("sunrise") val sunriseTimestamp: Long? = null,
    @SerialName("sunset") val sunsetTimestamp: Long? = null
)