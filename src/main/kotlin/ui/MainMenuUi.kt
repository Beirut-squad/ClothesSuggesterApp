package org.example.ui

import org.example.logic.exceptions.*
import org.example.ui.components.Reader
import org.example.ui.components.UiFeature
import org.example.ui.components.Viewer

class MainMenuUi(
    private val viewer: Viewer,
    private val reader: Reader,
    private val clothesSuggesterUi: ClothesSuggesterUi
) : UiFeature {
    override fun show() {
        viewer.printWelcomeMessage("Welcome")
        viewer.printTitle("Clothes Suggester App is ready")

        var isRunning = true
        while (isRunning) {
            viewer.printOptions(
                "Suggest outfit for a person",
                "Exit"
            )

            viewer.printInfoLine("Enter your choice:")

            val input = reader.readInt()
            try {
                when (input) {
                    1 -> {
                        clothesSuggesterUi.show()
                    }

                    2 -> {
                        viewer.printGoodbyeMessage("Goodbye :)")
                        isRunning = false
                    }
                    else -> {
                        viewer.printError("Invalid option")
                    }
                }
            }catch (w: WeatherServiceAuthenticationException){
                viewer.printError("${w.message}, check your subscription !!")
                println()
            }catch (c: CityNotFoundException){
                viewer.printError("${c.message} , make sure you entered the correct name !!")
                println()
            }catch (w: WeatherServiceException){
                viewer.printError("${w.message}")
                println()
            }catch (w: WeatherDataNotFoundException){
                viewer.printError("${w.message} , make sure you entered the correct name !!")
                println()
            }catch (u: UnexpectedWeatherException){
                viewer.printError("${u.message}")
                println()
            }catch (e: Exception){
                viewer.printError("${e.message}")
            }
        }
    }
}