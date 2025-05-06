package dto_helpers

import org.example.data.dto.CountryMetaDataDto

fun createCountryMetaDataHelper(
    type: Int = 1,
    id: Int = 2514,
    country: String = "EG",
    sunriseTimestamp: Long = 1746414520,
    sunsetTimestamp: Long = 1746462879,
) : CountryMetaDataDto{
    return CountryMetaDataDto(
        type = type,
        id = id,
        country = country,
        sunriseTimestamp = sunriseTimestamp,
        sunsetTimestamp = sunsetTimestamp,
    )
}