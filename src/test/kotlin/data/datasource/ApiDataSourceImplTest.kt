package data.datasource

import kotlinx.coroutines.test.runTest
import org.example.data.datasource.ApiDataSourceImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ApiDataSourceImplTest {
    private lateinit var apiDataSourceImpl: ApiDataSourceImpl

    @BeforeEach
    fun setUp() {
        apiDataSourceImpl = ApiDataSourceImpl()
    }

    @Test
    fun `should return successful response with code 200 when successfully connecting to weather api`() {
        runTest {
            // Given
            val city = "london"
            val language = "ar"

            // When
            val result = apiDataSourceImpl.getWeatherData(city, language)

            // Then
            assertEquals(SUCCESSFUL_CODE, result.httpResponseCode)
            assertNotNull(result)
        }
    }

    @Test
    fun `should throw exception when no data for the given city`() {
        runTest {
            // Given
            val city = "invalid city"
            val language = "en"

            // When & Then
            assertThrows<Exception> {
                apiDataSourceImpl.getWeatherData(city, language)
            }
        }
    }

    companion object {
        const val SUCCESSFUL_CODE = 200
        const val NOT_FOUND_CODE = 404
    }
}
