package com.example.simplecmp.domain

import kotlinx.datetime.LocalDate
import kotlinx.datetime.YearMonth

data class CalendarMonth(
    val yearMonth: YearMonth,
    val days: List<LocalDate?>
)
