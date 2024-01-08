package com.raedghazal.kotlinx_datetime_ext

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours

class LocalDateTimeExtTest {

    @Test
    fun test_startOfDay() {
        val localDate = LocalDate(2023, 12, 17).atStartOfDay()
        val expected = LocalDateTime(2023, 12, 17, 0, 0)

        assertEquals(expected, localDate)
    }

    @Test
    fun test_endOfDay() {
        val localDate = LocalDate(2023, 12, 17).atEndOfDay()
        val expected = LocalDateTime(2023, 12, 17, 23, 59, 59, 999999999)

        assertEquals(expected, localDate)
    }

    @Test
    fun test_durationUntil() {
        val firstDateTime = LocalDateTime(2023, 12, 12, 5, 0)
        val secondDateTime = firstDateTime + 7.hours
        val durationInSeconds = firstDateTime durationUntil secondDateTime
        val expected = 7.hours

        assertEquals(expected, durationInSeconds)
    }

}