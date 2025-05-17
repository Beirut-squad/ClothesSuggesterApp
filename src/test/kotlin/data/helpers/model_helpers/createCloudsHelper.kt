package data.helpers.model_helpers

import org.example.logic.models.extra_models.Clouds

fun createCloudsHelper(
    cloudPercentage: Int = 19
): Clouds {
    return Clouds(
        cloudsPercentage = cloudPercentage
    )
}