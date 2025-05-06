package org.example.di

import org.example.data.datasource.ApiDataSourceImpl
import org.example.data.datasource.DataSource
import org.example.data.repositories.WeatherRepositoryImpl
import org.example.logic.repositories.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
    single<DataSource> {
        ApiDataSourceImpl()
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl()
    }
}