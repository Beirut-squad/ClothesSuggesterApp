package helper

import org.example.logic.models.Wind

fun createWindHelper(
    speed: Double = 30.0,
    degree: Int = 60
): Wind{
    return Wind(
        speed = speed,
        degree = degree,
        gust = 10.0
    )
}