package data.helpers.model_helpers

import org.example.logic.models.AtmosphericDetails
import org.example.logic.models.Clouds
import org.example.logic.models.Weather
import org.example.logic.models.WeatherData
import org.example.logic.models.Wind

fun createWeatherDataHelper(
    weather: List<Weather>? = listOf(createWeatherHelper()),
    base: String? = "stations",
    atmosphericData: AtmosphericDetails = createAtmosphericDetailsHelper(),
    visibility: Int = 8000,
    wind: Wind = createWindHelper(),
    clouds: Clouds = createCloudsHelper(),
    timeOfResponse: Long = 1746470644,
    timeZone: Int = 10800,
    id: Int = 360630,
    name: String = "Cairo",
    httpResponseCode: Int = 200
): WeatherData {
    return WeatherData(
        weather = weather,
        base = base,
        atmosphericData = atmosphericData,
        visibility = visibility,
        wind = wind,
        clouds = clouds,
        timeOfResponse = timeOfResponse,
        timezone = timeZone,
        id = id,
        name = name,
        httpResponseCode = httpResponseCode,
    )
}