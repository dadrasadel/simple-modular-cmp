package com.example.simplecmp.core.data.network

import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.request.HttpRequestBuilder

val AppHeaderInterceptor = createClientPlugin("AppHeaderInterceptor") {
    onRequest { request, _ ->
        request.headers.append("X-App-Name", "simple-modular-cmp")
    }
}

fun HttpRequestBuilder.applyAppHeaders() {
    headers.append("X-App-Source", "core-data")
}
