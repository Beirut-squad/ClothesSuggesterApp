package data.repository

import data.helpers.dto_helpers.createWeatherResponseDtoHelper
import data.helpers.model_helpers.createWeatherDataHelper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.example.data.datasource.WeatherDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class WeatherRepositoryImplTest {

    private val weatherDataSource : WeatherDataSource = mockk()
    private lateinit var weatherRepositoryImpl: WeatherRepositoryImpl

    @BeforeEach
    fun setUp() {
        weatherRepositoryImpl = WeatherRepositoryImpl(weatherDataSource)
    }

    @Test
    fun `should return weather data when successfully fetching data from api`() {
        runTest {
            // Given
            val city = "cairo"
            val expectedResult = createWeatherDataHelper()
            coEvery { weatherDataSource.getWeatherData(city) } returns createWeatherResponseDtoHelper()

            // When
            val result = weatherRepositoryImpl.getWeatherData(city)

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
                weatherRepositoryImpl.getWeatherData(city)
            }
        }
    }
}