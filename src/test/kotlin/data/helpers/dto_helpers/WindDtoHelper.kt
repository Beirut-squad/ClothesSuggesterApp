package data.helpers.dto_helpers

import org.example.data.dto.WindDto

fun createWindDtoHelper(
    speed: Double = 2.57,
    degree: Int = 340,
    gust: Double = 35.0,
): WindDto {
    return WindDto(
        speed = speed,
        degree = degree,
        gust = gust
    )
}