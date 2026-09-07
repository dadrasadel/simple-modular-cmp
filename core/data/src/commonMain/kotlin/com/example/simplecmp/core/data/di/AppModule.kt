package com.example.simplecmp.core.data.di

import com.example.simplecmp.core.data.local.AppDataStore
import org.koin.dsl.module

val appModule = module {
    single { AppDataStore() }
}
