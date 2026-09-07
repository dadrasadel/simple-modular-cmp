package com.example.simplecmp.core.data.network

interface RemoteDataSource<T> {
    suspend fun fetch(): T
}
