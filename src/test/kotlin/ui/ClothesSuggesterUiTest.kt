package ui

import io.mockk.mockk
import org.example.logic.usecases.SuggestOutfitUseCase
import org.example.ui.ClothesSuggesterUi
import org.example.ui.components.Reader
import org.example.ui.components.Viewer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.Writer

class ClothesSuggesterUiTest{

    private lateinit var clothesSuggesterUi: ClothesSuggesterUi
    private var reader: Reader = mockk(relaxed = true)
    private var viewer: Viewer = mockk(relaxed = true)
    private var suggestOutfitUseCase: SuggestOutfitUseCase = mockk(relaxed = true)

    @BeforeEach
    fun setup(){
        clothesSuggesterUi = ClothesSuggesterUi(reader,viewer,suggestOutfitUseCase)
    }

    @Test
    fun ` should show  `(){
        // Given

        // When

        // Then
    }
}