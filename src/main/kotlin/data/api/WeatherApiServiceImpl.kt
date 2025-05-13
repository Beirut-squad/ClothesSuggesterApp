package org.example.data.api

import data.exception.NotFoundException
import data.exception.ServerErrorException
import data.exception.UnAuthorizedException
import data.exception.UnknownApiException
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import org.example.data.utils.ApiKeyProvider

class WeatherApiServiceImpl() : WeatherApiService {
    override suspend fun getWeatherResponse(city: String): String {

        val client = HttpClient(CIO)
        val response = client.get(BASE_URL) {
            parameter("q", city)
            parameter("appid", ApiKeyProvider.getApiKey())
            parameter("units", "metric")
        }

        val apiErrorCode = response.status.value
        when (apiErrorCode) {
            in 200..299 -> {
                return response.bodyAsText()
            }

            401 -> throw UnAuthorizedException()
            404 -> throw NotFoundException()

            in 500..599 -> throw ServerErrorException()

            else -> throw UnknownApiException()
        }
    }

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather"
    }

}

