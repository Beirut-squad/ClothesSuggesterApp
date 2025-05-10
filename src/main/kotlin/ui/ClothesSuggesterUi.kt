package org.example.ui

import kotlinx.coroutines.runBlocking
import org.example.logic.models.Outfit
import org.example.logic.usecases.SuggestOutfitUseCase
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
        var running = true
        while (running) {
            viewer.printOptions(
                "Get an outfit based on current temperature",
                "go back"
            )

            viewer.printInfoLine("Enter your choice:")
            val input = reader.readInput()
            when (input) {
                "1" -> {
                    goToSuggestion()
                }
                "2" -> running= false
                else -> viewer.printError("Invalid option")
            }
        }
    }


    private fun goToSuggestion() {
        val cityName = readCity()
        runBlocking { suggestRandomOutfit(cityName) }
    }

    private fun readCity(): String{
        while (true){
            viewer.printInfoLine("enter the city name: ")
            val cityName = reader.readInput()?.replace(" ","")
            if (cityName == "" || cityName == null){
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
        viewer.printTitle("\nThis is a suitable outfit for the weather right now , enjoy your day :) ")
        viewer.printCorrectOutput("For head wear : ${outfit.headWear}")
        viewer.printCorrectOutput("For upper body wear : ${outfit.upperBody}")
        viewer.printCorrectOutput("For lower body wear : ${outfit.lowerBody}")
        viewer.printCorrectOutput("For foot wear : ${outfit.footWear}\n")
    }
}