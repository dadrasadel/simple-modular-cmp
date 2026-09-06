package com.example.simplecmp.common

sealed interface AppResult<out T> {
    data class Success<T>(val value: T) : AppResult<T>
    data class Error(val message: String) : AppResult<Nothing>
    data object Loading : AppResult<Nothing>
}
