package org.example.di

import org.example.data.datasource.ApiDataSourceImpl
import org.example.data.datasource.DataSource
import data.repository.WeatherRepositoryImpl
import org.example.data.api.WeatherApiService
import org.example.data.api.WeatherApiServiceImpl
import org.example.logic.repositories.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<WeatherApiService> {
        WeatherApiServiceImpl()
    }
    single<DataSource> {
        ApiDataSourceImpl(get())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }
}