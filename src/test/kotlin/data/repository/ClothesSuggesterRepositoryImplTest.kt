package data.repository

import data.helpers.dto_helpers.createWeatherResponseDtoHelper
import data.helpers.model_helpers.createWeatherDataHelper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import logic.repository.ClothesSuggesterRepository
import org.example.data.repository.OutfitsDataSource
import org.example.data.repository.WeatherDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class ClothesSuggesterRepositoryImplTest {

    private val weatherDataSource : WeatherDataSource = mockk()
    private val outfitsDataSource : OutfitsDataSource = mockk()
    private lateinit var clothesSuggesterRepositoryImpl: ClothesSuggesterRepositoryImpl

    @BeforeEach
    fun setUp() {
        clothesSuggesterRepositoryImpl = ClothesSuggesterRepositoryImpl(weatherDataSource,outfitsDataSource)
    }

    @Test
    fun `should return weather data when successfully fetching data from api`() {
        runTest {
            // Given
            val city = "cairo"
            val expectedResult = createWeatherDataHelper()
            coEvery { weatherDataSource.getWeatherData(city) } returns createWeatherResponseDtoHelper()

            // When
            val result = clothesSuggesterRepositoryImpl.getWeatherData(city)

            // Then
            assertEquals(result, expectedResult)
        }
    }

    @Test
    fun `should throw exception when fails to fetch data from api`() {
        runTest {
            // Given
            val city = "cairo"
            coEvery { weatherDataSource.getWeatherData(city) } throws Exception()

            // When & Then
            assertFailsWith<Exception> {
                clothesSuggesterRepositoryImpl.getWeatherData(city)
            }
        }
    }
}