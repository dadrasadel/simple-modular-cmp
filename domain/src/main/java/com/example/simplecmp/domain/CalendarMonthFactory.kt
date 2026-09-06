package com.example.simplecmp.domain

import java.time.LocalDate
import java.time.YearMonth

object CalendarMonthFactory {
    fun create(yearMonth: YearMonth): CalendarMonth {
        val firstDay = yearMonth.atDay(1)
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstWeekday = (firstDay.dayOfWeek.value + 6) % 7
        val days = buildList {
            repeat(firstWeekday) { add(null) }
            for (day in 1..daysInMonth) add(yearMonth.atDay(day))
        }
        return CalendarMonth(yearMonth = yearMonth, days = days)
    }
}
