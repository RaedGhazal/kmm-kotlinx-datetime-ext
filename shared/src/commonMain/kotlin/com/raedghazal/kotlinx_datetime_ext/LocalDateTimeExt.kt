package com.raedghazal.kotlinx_datetime_ext

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

const val DAY_HOURS = 24L
val LocalTime.Companion.MIN get() = LocalTime(0, 0)
val LocalTime.Companion.MAX get() = LocalTime(23, 59, 59, 999999999)

fun LocalDateTime.Companion.now(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime {
    return Clock.System.now().toLocalDateTime(timeZone)
}

fun LocalDate.Companion.now(): LocalDate {
    return LocalDateTime.now().date
}

fun LocalTime.Companion.now(): LocalTime {
    return LocalDateTime.now().time
}

fun LocalDate.atStartOfDay(): LocalDateTime {
    return LocalDateTime(this, LocalTime.MIN)
}

fun LocalDate.atEndOfDay(): LocalDateTime {
    return LocalDateTime(this, LocalTime.MAX)
}

fun instantBetween(
    start: LocalDateTime,
    end: LocalDateTime,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): Duration {
    if (end < start) throw IllegalArgumentException("end must be greater than start")

    return end.toInstant(timeZone) - start.toInstant(timeZone)
}