package org.example.data.utils

import kotlinx.io.files.FileNotFoundException
import java.io.FileInputStream
import java.util.Properties

object ApiKeyProvider {

    fun getApiKey(): String {
        return try {
            val properties = Properties()
            val file = FileInputStream("local.properties")
            properties.load(file)
            properties.getProperty("API_KEY")
                ?: throw IllegalStateException("API_KEY not found in local.properties")
        } catch (e: FileNotFoundException) {
            throw IllegalStateException("local.properties file not found", e)
        }
    }
}