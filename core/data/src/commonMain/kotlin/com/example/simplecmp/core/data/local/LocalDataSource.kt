package com.example.simplecmp.core.data.local

interface LocalDataSource<T> {
    suspend fun read(): T?
    suspend fun write(value: T)
}
