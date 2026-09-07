package com.example.simplecmp.core.data.di

import com.example.simplecmp.core.data.model.AppModel
import com.example.simplecmp.core.data.repository.AppRepository
import org.koin.dsl.module

class AppRepositoryImpl : AppRepository {
    override fun getApps(): List<AppModel> = listOf(
        AppModel(id = "calendar", title = "Calendar")
    )
}

val repositoryModule = module {
    single<AppRepository> { AppRepositoryImpl() }
}
