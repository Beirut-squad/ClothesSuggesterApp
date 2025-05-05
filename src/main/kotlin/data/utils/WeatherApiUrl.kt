package org.example.data.utils

object WeatherApiUrl {
    var city: String = ""
    var language: String = "en"
    var baseUrl: String = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=748f0749293fa00b514a285450d6581f&units=metric&lang=$language"

}