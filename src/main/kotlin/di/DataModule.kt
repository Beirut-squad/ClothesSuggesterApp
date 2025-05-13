package org.example.di

import org.example.data.datasource.WeatherDataSourceImpl
import org.example.data.datasource.WeatherDataSource
import data.repository.WeatherRepositoryImpl
import org.example.data.api.WeatherApiService
import org.example.data.api.WeatherApiServiceImpl
import logic.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<WeatherApiService> {
        WeatherApiServiceImpl()
    }
    single<WeatherDataSource> {
        WeatherDataSourceImpl(get())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }
}