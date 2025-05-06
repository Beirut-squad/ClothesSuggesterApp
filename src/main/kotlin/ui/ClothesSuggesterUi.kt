package org.example.ui

import org.example.logic.usecases.SuggestOutfitUseCase
import org.example.ui.components.Reader
import org.example.ui.components.UiFeature
import org.example.ui.components.Viewer

class ClothesSuggesterUi(
    private val reader: Reader,
    private val viewer: Viewer,
    private val suggestOutfitUseCase: SuggestOutfitUseCase
    ) : UiFeature {
    override fun show() {

    }
}