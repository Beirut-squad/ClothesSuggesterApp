package logic.usecases

import com.google.common.base.CharMatcher.any
import com.google.common.truth.Truth.assertThat
import helper.createAtmosphericDetailsHelper
import helper.createCloudsHelper
import helper.createWeatherHelper
import helper.createWindHelper
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.example.logic.helper.*
import org.example.logic.models.Weather
import org.example.logic.repositories.WeatherRepository
import org.example.logic.usecases.SuggestOutfitUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class SuggestOutfitUseCaseTest{

    private lateinit var suggestOutfitUseCase: SuggestOutfitUseCase
    private lateinit var weatherRepository: WeatherRepository


    @BeforeEach
    fun setup(){
        weatherRepository = mockk()
        suggestOutfitUseCase = SuggestOutfitUseCase(weatherRepository)
    }

    @Test
    fun `should throw exception if the atmospheric data is recieved but temperature and feels like temp info was not recieved `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns null
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike } returns null




        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun ` should throw exception if the atmospheric data is recieved but temperature or feels like temp info was not recieved   `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 30.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike } returns null




        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun `should throw exception if the atmospheric data is recieved but temperature or feels like temp info was not recieved `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns null
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike } returns 30.0




        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun `should throw exception  if atmospheric data was not recieved  `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns null

        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun `should throw exception if no temperature atmospheric data info was recieved  `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns null


        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun `should throw exception if no feels like temperature atmospheric data info was recieved  `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike } returns null

        // When and Then
        assertThrows<Exception> {
            suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        }
    }

    @Test
    fun `should return a freezing suitable outfit when the avg temp is below 7 `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 6.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 4.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")

        // Then
        assertThat(result).isIn(freezingOutfits)
    }

    @Test
    fun `should return a cold suitable outfit when the avg temp is from 7,1 to 13 `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 10.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 10.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")

        // Then
        assertThat(result).isIn(coldOutfits)
    }

    @Test
    fun `should return an average suitable outfit when the avg temp is from 13,1 to 18 `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 15.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 17.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")

        // Then
        assertThat(result).isIn(averageOutfits)
    }

    @Test
    fun `should return a warm suitable outfit when the avg temp is from 13,1 to 18 `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 24.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 20.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")

        // Then
        assertThat(result).isIn(warmOutfits)
    }

    @Test
    fun `should return an hot suitable outfit when the avg temp is from 13,1 to 18 `() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 40.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 30.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")

        // Then
        assertThat(result).isIn(hotOutfits)
    }

    @Test
    fun `should return a death suitable outfit when the avg temp is above 50`() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns 100.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns 100.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        // Then
        assertThat(result).isIn(deathOutfits)
    }

    @Test
    fun `should return a death suitable outfit when the avg temp is bellow -50`() = runTest{
        // Given
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData } returns createAtmosphericDetailsHelper()
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.temperature } returns -80.0
        coEvery { weatherRepository.getWeatherData(any()).atmosphericData?.feelsLike  } returns -80.0

        // When
        val result = suggestOutfitUseCase.getOutfitBasedOnTemperature("")
        // Then
        assertThat(result).isIn(deathOutfits)
    }
}