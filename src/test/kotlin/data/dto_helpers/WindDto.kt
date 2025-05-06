package data.dto_helpers

import org.example.data.dto.WindDto

fun createWindDtoHelper(
    speed: Double = 2.57,
    degree: Int = 340
): WindDto {
    return WindDto(speed = 0.0, degree = 0)
}