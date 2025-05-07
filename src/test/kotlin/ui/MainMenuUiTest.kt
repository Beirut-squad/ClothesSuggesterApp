package ui

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.example.ui.ClothesSuggesterUi
import org.example.ui.MainMenuUi
import org.example.ui.components.Reader
import org.example.ui.components.Viewer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MainMenuUiTest {

    private val reader: Reader = mockk(relaxed = true)
    private val viewer: Viewer = mockk(relaxed = true)
    private val clothesSuggesterUi: ClothesSuggesterUi = mockk(relaxed = true)
    private lateinit var mainMenuUi: MainMenuUi

    @BeforeEach
    fun setUp() {
        mainMenuUi = MainMenuUi(viewer, reader, clothesSuggesterUi)
    }

    @Test
    fun `should print welcome message and options when show is called`() {
        // Given
        every { reader.readInt() } returnsMany listOf(1, 2)

        // Then
        mainMenuUi.show()

        // When
        verify { viewer.printWelcomeMessage("Welcome") }
        verify { viewer.printTitle("Clothes Suggester App is ready") }
        verify {
            viewer.printOptions(
                "Suggest outfit for a person",
                "Exit"
            )
        }
    }

    @Test
    fun `should call clothes suggester when entering option 1`() {
        // Given
        every { reader.readInt() } returnsMany listOf(1, 2)

        // When
        mainMenuUi.show()

        // Then
        verify(exactly = 1) { clothesSuggesterUi.show() }
    }

    @Test
    fun `should show goodbye message and exits when entering option 2`() {
        // Given
        every { reader.readInt() } returns 2

        // When
        mainMenuUi.show()

        // Then
        verify(exactly = 1) { viewer.printGoodbyeMessage("Goodbye :)") }
    }

    @Test
    fun `should print error message when entering non numeric values for option`() {
        // Given
        every { reader.readInt() } returnsMany listOf(null, 2)

        // When
        mainMenuUi.show()

        // Then
        verifyOrder {
            viewer.printWelcomeMessage("Welcome")
            viewer.printTitle("Clothes Suggester App is ready")
            viewer.printOptions(
                "Suggest outfit for a person",
                "Exit"
            )
            viewer.printInfoLine("Enter your choice:")
            viewer.printError("Invalid option")
        }
    }

    @Test
    fun `should print error message when entering invalid number for option`() {
        // Given
        every { reader.readInt() } returnsMany listOf(50, 2)

        // When
        mainMenuUi.show()

        // Then
        verifyOrder {
            viewer.printWelcomeMessage("Welcome")
            viewer.printTitle("Clothes Suggester App is ready")
            viewer.printOptions(
                "Suggest outfit for a person",
                "Exit"
            )
            viewer.printInfoLine("Enter your choice:")
            viewer.printError("Invalid option")
        }
    }

}