package com.example.simplecmp.domain

import java.time.LocalDate

data class CalendarDate(
    val date: LocalDate,
    val isToday: Boolean = false,
)
