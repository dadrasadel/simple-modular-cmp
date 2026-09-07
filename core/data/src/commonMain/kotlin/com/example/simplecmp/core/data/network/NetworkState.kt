package com.example.simplecmp.core.data.network

sealed interface NetworkState {
    data object Connected : NetworkState
    data object Disconnected : NetworkState
}
