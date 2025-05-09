package org.example.logic.exceptions

class WeatherServiceAuthenticationException(message: String) : Exception(message)

class CityNotFoundException(message: String) : Exception(message)

class WeatherServiceException(message: String) : Exception(message)

class UnexpectedWeatherException(message: String) : Exception(message)