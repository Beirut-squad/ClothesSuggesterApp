package dto_helpers

import org.example.data.dto.AtmosphericDetailsDto
import org.example.data.dto.CloudsDto
import org.example.data.dto.CoordinatesDto
import org.example.data.dto.CountryMetaDataDto
import org.example.data.dto.WeatherDto
import org.example.data.dto.WeatherResponseDto
import org.example.data.dto.WindDto
import kotlin.Int

fun createWeatherResponseDtoHelper(
    coordinateDto: CoordinatesDto = createCoordinatesDtoHelper(),
    weatherDto: List<WeatherDto> = listOf(createWeatherDtoHelper()),
    base: String = "stations",
    atmosphericDataDto: AtmosphericDetailsDto = createAtmosphericDetailsDtoHelper(),
    visibility: Int = 8000,
    windDto: WindDto = createWindDtoHelper(),
    cloudsDto: CloudsDto = createCloudsDtoHelper(),
    timeOfResponse: Long = 1746470644,
    countryMetaDataDto: CountryMetaDataDto = createCountryMetaDataHelper(),
    timezone: Int = 10800,
    id: Int = 360630,
    name: String = "Cairo",
    httpResponseCode: Int = 200

): WeatherResponseDto {
    return WeatherResponseDto(
        coordinatesDto = coordinateDto,
        weathers = weatherDto,
        base = base,
        atmosphericDataDto = atmosphericDataDto,
        visibility = visibility,
        windDto = windDto,
        cloudsDto = cloudsDto,
        timeOfResponse = timeOfResponse,
        countryMetaDataDto = countryMetaDataDto,
        timezone = timezone,
        id = id,
        name = name,
        httpResponseCode = httpResponseCode
    )
}