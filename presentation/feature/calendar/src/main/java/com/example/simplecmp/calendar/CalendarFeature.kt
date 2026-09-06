package com.example.simplecmp.calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.simplecmp.domain.CalendarMonthFactory
import com.example.simplecmp.presentation.ui.AppTheme
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CalendarFeature() {
    val today = remember { LocalDate.now() }
    var currentMonth = remember { mutableStateOf(YearMonth.from(today)) }
    var selectedDay = remember { mutableStateOf(today) }

    val month = CalendarMonthFactory.create(currentMonth.value)

    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(Color(0xFFF6F0E8), Color(0xFFE8F1FF))
                        )
                    )
                    .padding(20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 760.dp)
                        .align(Alignment.TopCenter)
                ) {
                    Text(
                        text = "simple modular cmp",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "A modular calendar-only starter.",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            MonthHeader(
                                monthLabel = month.yearMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault()),
                                year = month.yearMonth.year,
                                onPrevious = { currentMonth.value = currentMonth.value.minusMonths(1) },
                                onNext = { currentMonth.value = currentMonth.value.plusMonths(1) }
                            )

                            WeekDaysRow()

                            FlowRow(
                                maxItemsInEachRow = 7,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                month.days.forEach { date ->
                                    CalendarCell(
                                        date = date,
                                        isToday = date == today,
                                        isSelected = date == selectedDay.value,
                                        onClick = { if (date != null) selectedDay.value = date },
                                    )
                                }
                            }

                            SelectedDayCard(selectedDay = selectedDay.value)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MonthHeader(
    monthLabel: String,
    year: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    RowFull(
        leading = {
            Text(
                text = "$monthLabel $year",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        },
        trailing = {
            RowFull(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                leading = { SmallNavButton(text = "‹", onClick = onPrevious) },
                trailing = { SmallNavButton(text = "›", onClick = onNext) }
            )
        }
    )
}

@Composable
private fun SmallNavButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF223354), contentColor = Color.White)
    ) { Text(text = text) }
}

@Composable
private fun WeekDaysRow() {
    FlowRow(
        maxItemsInEachRow = 7,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        java.time.DayOfWeek.entries.forEach {
            Text(
                text = it.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                modifier = Modifier.size(44.dp),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun CalendarCell(
    date: LocalDate?,
    isToday: Boolean,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val bg = when {
        isSelected -> Color(0xFF223354)
        isToday -> Color(0xFFF3C969)
        else -> Color.White
    }
    val fg = if (isSelected) Color.White else Color(0xFF1E1E1E)

    Card(
        onClick = { if (date != null) onClick() },
        modifier = Modifier.size(44.dp),
        colors = CardDefaults.cardColors(containerColor = bg),
        border = if (!isSelected) BorderStroke(1.dp, Color(0x22000000)) else null,
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 6.dp else 1.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = date?.dayOfMonth?.toString().orEmpty(),
                color = fg,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun SelectedDayCard(selectedDay: LocalDate) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7FA)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Selected day", style = MaterialTheme.typography.labelLarge)
            Text(
                text = selectedDay.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()) +
                    ", ${selectedDay.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${selectedDay.dayOfMonth}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun RowFull(
    leading: @Composable () -> Unit,
    trailing: @Composable () -> Unit,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
) {
    androidx.compose.foundation.layout.Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leading()
        trailing()
    }
}
