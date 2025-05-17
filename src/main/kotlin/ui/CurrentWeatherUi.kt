package org.example.ui

import kotlinx.coroutines.runBlocking
import org.example.logic.usecase.GetCurrentWeather
import org.example.ui.components.Reader
import org.example.ui.components.UiFeature
import org.example.ui.components.Viewer

class CurrentWeatherUi(
    val reader: Reader,
    val viewer: Viewer,
    val getCurrentWeather: GetCurrentWeather
) : UiFeature {
    override fun show() {
        val cityName = readCity()
        runBlocking {
            viewer.printLoader("Loading...")
            val temperature = getCurrentWeather.getCurrentTemperature(cityName)
            viewer.printCorrectOutput(
                "temperature in $cityName is:\n" +
                        "${temperature.first} ^C\n" +
                        "feels like: ${temperature.second} ^C\n" +
                        "enjoy your day \uD83D\uDE0E"
            ) //
        }
    }

    private fun readCity(): String {
        while (true) {
            viewer.printInfoLine("enter the city name: ")

            val cityName = reader.readInput()
            if (cityName.isNullOrBlank()) {
                viewer.printError("Please enter a city")
                continue
            }
            return cityName
        }
    }
}