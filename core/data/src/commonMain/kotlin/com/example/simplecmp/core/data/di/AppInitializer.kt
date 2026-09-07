package com.example.simplecmp.core.data.di

import org.koin.core.context.startKoin

fun initCoreData() {
    startKoin {
        modules(
            appModule,
            platformModule,
            networkModule,
            repositoryModule,
            securityModule,
        )
    }
}
