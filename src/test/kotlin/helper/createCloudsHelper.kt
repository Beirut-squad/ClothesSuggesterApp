package helper

import org.example.logic.models.Clouds

fun createCloudsHelper(
    cloudPercentage: Int = 30
): Clouds{
    return Clouds(
        cloudsPercentage = cloudPercentage
    )
}