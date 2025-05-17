package data.helpers.model_helpers

import org.example.logic.models.extra_models.Wind

fun createWindHelper(
    speed: Double = 2.57,
    degree: Int = 340,
    gust: Double = 35.0,
): Wind {
    return Wind(
        speed = speed,
        degree = degree,
        gust = gust
    )
}