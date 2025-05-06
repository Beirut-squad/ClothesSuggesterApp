package org.example.di

import org.example.logic.usecases.SuggestOutfitUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val logicModule = module {
    singleOf(::SuggestOutfitUseCase)
}