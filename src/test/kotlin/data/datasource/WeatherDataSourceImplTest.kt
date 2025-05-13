package data.datasource

import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.example.data.api.WeatherApiService
import org.example.data.datasource.WeatherDataSourceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class WeatherDataSourceImplTest {
    private val weatherService: WeatherApiService = mockk(relaxed = true)
    private lateinit var weatherDataSource: WeatherDataSourceImpl

    @BeforeEach
    fun setUp() {
        weatherDataSource = WeatherDataSourceImpl(weatherService)
    }

    @Test
    fun `should throw exception when no data for the given city`() {
        runTest {
            // Given
            val city = "invalid city"

            // When & Then
            assertThrows<Exception> {
                weatherDataSource.getWeatherData(city)
            }
        }
    }

}
