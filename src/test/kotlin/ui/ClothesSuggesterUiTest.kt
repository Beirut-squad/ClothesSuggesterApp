package ui

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.example.logic.models.Outfit
import logic.usecase.SuggestOutfitUseCase
import org.example.ui.ClothesSuggesterUi
import org.example.ui.components.Reader
import org.example.ui.components.Viewer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ClothesSuggesterUiTest {

    private lateinit var clothesSuggesterUi: ClothesSuggesterUi
    private var reader: Reader = mockk(relaxed = true)
    private var viewer: Viewer = mockk(relaxed = true)
    private var suggestOutfitUseCase: SuggestOutfitUseCase = mockk(relaxed = true)

    @BeforeEach
    fun setup() {
        clothesSuggesterUi = ClothesSuggesterUi(reader, viewer, suggestOutfitUseCase)
    }

    @Disabled
    @Test
    fun ` should show welcome message and option for the user to pick `() {
        // Given
        every { reader.readInput() } returns "2"
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printWelcomeMessage("Welcome to outfit suggester ") }
        verify {
            viewer.printOptions(
                "Get an outfit",
                "go back"
            )
        }
        verify { viewer.printInfoLine("Enter your choice:") }
    }

    @Disabled
    @Test
    fun ` should show  welcome message and option for the user to pick `() {
        // Given
        every { reader.readInput() } returns "55"
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printWelcomeMessage("Welcome to outfit suggester ") }
        verify {
            viewer.printOptions(
                "Get an outfit",
                "go back"
            )
        }
        verify { viewer.printInfoLine("Enter your choice:") }
    }

    @Disabled
    @Test
    fun ` should ask the user to enter city name and language if user picks to get an outfit `() {
        // Given
        every { reader.readInput() } returnsMany listOf("1", "2")
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printInfoLine("enter the city name: ") }
    }

    @Disabled
    fun ` should print error message if user didn't enter a city name`() {
        // Given
        every { reader.readInput() } returnsMany listOf("1", "   ", "2")
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printError("Please enter a city") }
    }

    @Disabled
    @Test
    fun ` should print error message if  user didn't enter a city name`() {
        // Given
        every { reader.readInput() } returnsMany listOf("1", null, "2")
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printError("Please enter a city") }
    }


    @Disabled
    @Test
    fun ` should print error message if user didn't enter a language `() {
        // Given
        every { reader.readInput() } returnsMany listOf("1", "cairo", "   ", "2")
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printError("Please enter a language") }
    }

    @Disabled
    @Test
    fun ` should print  error message if user didn't enter a language `() {
        // Given
        every { reader.readInput() } returnsMany listOf("1", "cairo", null, "2")
        // When
        clothesSuggesterUi.show()

        // Then
        verify { viewer.printError("Please enter a language") }
    }

    @Disabled
    @Test
    fun ` should print outfit details user enters a city name`() {
        val outfit = Outfit(
            headWear = "cap",
            upperBody = "t-shirt",
            lowerBody = "jeans",
            footWear = "sandal"
        )
        runBlocking {
            // Given
            every { reader.readInput() } returnsMany listOf("1", "cairo", "2")
            coEvery { suggestOutfitUseCase.getOutfitBasedOnTemperature("cairo") } returns outfit
            // When
            clothesSuggesterUi.show()

            // Then
            verify { viewer.printTitle("\nThis is a suitable outfit for the weather right now , enjoy your day :) ") }
            verify { viewer.printCorrectOutput("For head wear : ${outfit.headWear}") }
            verify { viewer.printCorrectOutput("For upper body wear : ${outfit.upperBody}") }
            verify { viewer.printCorrectOutput("For lower body wear : ${outfit.lowerBody}") }
            verify { viewer.printCorrectOutput("For foot wear : ${outfit.footWear}\n") }
        }

    }
}