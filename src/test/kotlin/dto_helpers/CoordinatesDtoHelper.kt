package dto_helpers

import org.example.data.dto.CoordinatesDto

fun createCoordinatesDtoHelper(
    lat: Double = 31.2497,
    lon: Double = 30.0626
): CoordinatesDto {
    return CoordinatesDto(lat, lon)
}
