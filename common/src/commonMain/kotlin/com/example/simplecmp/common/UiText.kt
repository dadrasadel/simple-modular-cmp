package com.example.simplecmp.common

sealed interface UiText {
    data class DynamicString(val value: String) : UiText
}
