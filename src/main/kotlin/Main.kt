package org.example

import org.example.di.dataModule
import org.example.di.logicModule
import org.example.di.uiModule
import org.example.ui.MainMenuUi
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform.getKoin

fun main() {
    startKoin {
        modules(
            uiModule,
            logicModule,
            dataModule
        )
    }

    val mainMenuUi: MainMenuUi = getKoin().get()
    mainMenuUi.show()

}
