package com.example.simplecmp.core

object AppLogger {
    fun log(message: String) {
        println("${AppInfo.tag}: $message")
    }
}
