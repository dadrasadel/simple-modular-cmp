package com.example.simplecmp.domain

import kotlinx.datetime.LocalDate

data class CalendarDate(
    val date: LocalDate,
    val isToday: Boolean = false,
)
