package org.example.ui

import org.example.ui.components.Reader
import org.example.ui.components.UiFeature
import org.example.ui.components.Viewer

class MainMenuUi(
    private val viewer: Viewer,
    private val reader: Reader,
    private val clothesSuggesterUi: ClothesSuggesterUi
) : UiFeature {
    override fun show() {
        viewer.printTitle("Clothes Suggester UI is ready")

        var running = true
        while (running) {
            viewer.printOptions(
                "Suggest outfit for a person",
                "Exit"
            )

            viewer.printInfoLine("Enter your choice:")

            val input = reader.readInt()
            when (input) {
                1 -> {
                    gotToSuggestOutfitUi()
                }
                else -> running = false
            }

        }
    }

    private fun gotToSuggestOutfitUi() {
        clothesSuggesterUi.show()
    }
}