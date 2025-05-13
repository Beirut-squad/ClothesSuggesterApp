package org.example.di

import logic.usecase.SuggestOutfitUseCase
import org.example.logic.usecase.GetCurrentWeather

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val logicModule = module {
    singleOf(::SuggestOutfitUseCase)
    singleOf(::GetCurrentWeather)

}