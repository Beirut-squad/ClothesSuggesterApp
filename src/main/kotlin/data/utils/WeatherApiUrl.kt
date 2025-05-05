package org.example.data.utils

import org.intellij.lang.annotations.Language

object WeatherApiUrl {
    fun getUrl(city: String = "cairo", language: String = "en"): String {
        val baseUrl: String =
            "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=748f0749293fa00b514a285450d6581f&units=metric&lang=${language}"
        return baseUrl
    }
}