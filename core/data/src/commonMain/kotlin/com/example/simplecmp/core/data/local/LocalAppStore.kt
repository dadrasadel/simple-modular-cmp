package com.example.simplecmp.core.data.local

class LocalAppStore {
    private val values = linkedMapOf<String, String>()

    fun put(key: String, value: String) {
        values[key] = value
    }

    fun get(key: String): String? = values[key]
}
