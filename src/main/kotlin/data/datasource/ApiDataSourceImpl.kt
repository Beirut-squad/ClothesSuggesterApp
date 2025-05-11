package org.example.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import org.example.data.dto.WeatherResponseDto
import data.exception.NotFoundException
import data.exception.ServerErrorException
import data.exception.UnAuthorizedException
import data.exception.UnknownApiException
import org.example.data.utils.ApiKeyProvider

class ApiDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : DataSource {

    override suspend fun getWeatherData(
        city: String
    ): WeatherResponseDto {
        val response = client.get(getUrl(city))

        val apiErrorCode = response.status.value
        when (apiErrorCode) {
            in 200..299 -> {
                return Json.decodeFromString<WeatherResponseDto>(response.bodyAsText())
            }

            401 -> throw UnAuthorizedException("Invalid Api Key")
            404 -> throw NotFoundException("No data found for the city: $city")

            in 500..599 -> throw ServerErrorException("Server Error: HTTP $apiErrorCode")

            else -> throw UnknownApiException("Unknown error $apiErrorCode")
        }
    }

    private fun getUrl(city: String): String {
        val url =
            "https://api.openweathermap.org/data/2.5/weather?q=${city}&" +
                    "appid=${ApiKeyProvider.getApiKey()}&" +
                    "units=metric"
        return url
    }

}