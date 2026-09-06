package com.example.simplecmp.domain

import java.time.LocalDate
import java.time.YearMonth

data class CalendarMonth(
    val yearMonth: YearMonth,
    val days: List<LocalDate?>
)
