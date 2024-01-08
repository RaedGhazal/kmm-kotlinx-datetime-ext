package com.raedghazal.kotlinx_datetime_ext

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTimeFormatterTest {

    @Test
    fun test_format_LocalDateTime_FullDateTimeFormatter() {
        val formatter = FullDateTimeFormatter
        val localDateTime = LocalDateTime(2023, 1, 1, 1, 1)
        val expected = "01/01/2023 - 01:01"

        assertEquals(expected, formatter.format(localDateTime))
    }

    @Test
    fun test_format_LocalDateTime_MonthYearFormatter() {
        val formatter = MonthYearFormatter
        val localDateTime = LocalDateTime(2023, 1, 1, 1, 1)
        val expected = "01/2023"

        assertEquals(expected, formatter.format(localDateTime))
    }

    @Test
    fun test_format_LocalDateTime_DateFormatter() {
        val formatter = DateFormatter
        val localDateTime = LocalDate(2023, 1, 1)
        val expected = "01/01/2023"

        assertEquals(expected, formatter.format(localDateTime))
    }

    @Test
    fun test_format_LocalDateTime_TimeFormatter() {
        val formatter = TimeFormatter
        val localDateTime = LocalTime(1, 1, 1)
        val expected = "01:01"

        assertEquals(
            expected,
            formatter.format(localDateTime)
        )
    }

    @Test
    fun test_parse_to_SqlDateTimeFormatter() {
        val formatter = SqlDateTimeFormatter
        val localDateTime = LocalDateTime(2023, 1, 1, 1, 1)
        assertEquals(
            localDateTime,
            formatter.parseToLocalDateTime("2023-01-01 01:01:00")
        )
    }

    @Test
    fun test_parse_DateFormatter_to_LocalDate() {
        val formatter = DateFormatter
        val expected = LocalDate(2023, 1, 1)
        assertEquals(
            expected,
            formatter.parseToLocalDate("01/01/2023")
        )
    }

    @Test
    fun test_parse_TimeFormatter_to_LocalTime() {
        val formatter = TimeFormatter
        val expected = LocalTime(1, 8, 0)
        assertEquals(
            expected,
            formatter.parseToLocalTime("01:08")
        )
    }

    @Test
    fun test_parse_to_PolishLocaleDateTimeFormatter() {
        val formatter = PolishLocaleDateTimeFormatter
        val localDateTime = LocalDateTime(2024, 1, 8, 18, 47, 12)
        assertEquals(
            localDateTime,
            formatter.parseToLocalDateTime("pon., 8 sty 2024 18:47:12")
        )
    }

    companion object {
        val SqlDateTimeFormatter =
            LocalDateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.en())
        val FullDateTimeFormatter: LocalDateTimeFormatter = LocalDateTimeFormatter
            .ofPattern("dd/MM/yyyy - HH:mm", Locale.en())
        val MonthYearFormatter: LocalDateTimeFormatter = LocalDateTimeFormatter
            .ofPattern("MM/yyyy", Locale.en())
        val DateFormatter: LocalDateTimeFormatter = LocalDateTimeFormatter
            .ofPattern("dd/MM/yyyy", Locale.en())
        val TimeFormatter: LocalDateTimeFormatter = LocalDateTimeFormatter
            .ofPattern("HH:mm", Locale.en())
        val PolishLocaleDateTimeFormatter: LocalDateTimeFormatter = LocalDateTimeFormatter
            .ofPattern("EEE, d MMM yyyy HH:mm:ss", Locale.forLanguageTag("pl-PL"))
    }
}
