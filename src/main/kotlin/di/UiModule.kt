package org.example.di

import org.example.ui.ClothesSuggesterUi
import org.example.ui.MainMenuUi
import org.example.ui.components.Colors
import org.example.ui.components.Reader
import org.example.ui.components.Viewer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    singleOf(::Colors)
    singleOf(::Viewer)
    singleOf(::Reader)
    singleOf(::MainMenuUi)
    singleOf(::ClothesSuggesterUi)
}