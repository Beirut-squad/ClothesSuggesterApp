package org.example.di

import org.example.data.datasource.WeatherDataSourceImpl
import org.example.data.repository.WeatherDataSource
import data.repository.ClothesSuggesterRepositoryImpl
import org.example.data.api.WeatherApiService
import org.example.data.api.WeatherApiServiceImpl
import logic.repository.ClothesSuggesterRepository
import org.example.data.repository.OutfitsDataSource
import org.example.data.datasource.OutfitsDataSourceImpl
import org.koin.dsl.module

val dataModule = module {

    single<WeatherApiService> {
        WeatherApiServiceImpl()
    }
    single<WeatherDataSource> {
        WeatherDataSourceImpl(get())
    }

    single<OutfitsDataSource> {
        OutfitsDataSourceImpl()
    }

    single<ClothesSuggesterRepository> {
        ClothesSuggesterRepositoryImpl(get(),get())
    }
}