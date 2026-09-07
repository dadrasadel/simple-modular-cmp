package com.example.simplecmp.core.data.repository

import com.example.simplecmp.core.data.model.AppModel

interface AppRepository {
    fun getApps(): List<AppModel>
}
