package org.example.ui

import kotlinx.coroutines.runBlocking
import org.example.logic.models.extra_models.Outfit
import logic.usecase.SuggestOutfitUseCase
import org.example.ui.components.Reader
import org.example.ui.components.UiFeature
import org.example.ui.components.Viewer

class ClothesSuggesterUi(
    private val reader: Reader,
    private val viewer: Viewer,
    private val suggestOutfitUseCase: SuggestOutfitUseCase,
) : UiFeature {
    override fun show() {
        viewer.printWelcomeMessage("Welcome to outfit suggester ")
        goToSuggestion()
    }


    private fun goToSuggestion() {
        val cityName = readCity()
        viewer.printLoader("Loading...")
        runBlocking { suggestRandomOutfit(cityName) }
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

    private suspend fun suggestRandomOutfit(cityName: String) {
        val randomOutfit = suggestOutfitUseCase.getOutfitBasedOnTemperature(cityName)
        showOutfitDetails(randomOutfit)
    }

    private fun showOutfitDetails(outfit: Outfit) {
        viewer.printTitle("\nThis is a suitable outfit for the weather right now , enjoy your day \uD83D\uDE0E ")
        viewer.printCorrectOutput("For head wear : ${outfit.headWear}")
        viewer.printCorrectOutput("For upper body wear : ${outfit.upperBody}")
        viewer.printCorrectOutput("For lower body wear : ${outfit.lowerBody}")
        viewer.printCorrectOutput("For foot wear : ${outfit.footWear}\n")
    }
}