package org.example.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.example.data.dto.WeatherResponseDto
import org.example.data.exceptions.CityNotFoundException
import org.example.data.utils.ApiKey

class ApiDataSourceImpl : DataSource {

    override suspend fun getWeatherData(
        city: String,
        language: String
    ): WeatherResponseDto {
        return runBlocking {
            val client = HttpClient(CIO)
            val response = client.get(getUrl(city, language))
            if (response.status.value != 200) {
                throw CityNotFoundException("No data found for the city: $city")
            }
            val weatherResponseDto: WeatherResponseDto =
                Json.decodeFromString<WeatherResponseDto>(response.bodyAsText())
            weatherResponseDto
        }
    }

    private fun getUrl(city: String, language: String): String {
        val baseUrl =
            "https://api.openweathermap.org/data/2.5/weather?q=${city}&" +
                    "appid=${ApiKey.API_KEY}&" +
                    "units=metric&lang=${language}"
        return baseUrl
    }

}