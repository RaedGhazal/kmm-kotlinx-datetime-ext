package com.raedghazal.kotlinx_datetime_ext

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlin.js.Date

actual class LocalDateTimeFormatter private constructor(
    private val pattern: String,
    private val locale: Locale
) {

    actual fun format(localDateTime: LocalDateTime): String {
        return DateFns.format(localDateTime.toDate(), pattern, obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        })
    }

    actual fun format(localTime: LocalTime): String {
        return DateFns.format(localTime.toDate(), pattern, obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        })
    }

    actual fun format(localDate: LocalDate): String {
        return DateFns.format(localDate.toDate(), pattern, obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        })
    }

    actual fun parseToLocalDateTime(str: String): LocalDateTime {
        return DateFns.parse(str, pattern, Date(), options = obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        }).toLocalDateTime()
    }

    actual fun parseToLocalDate(str: String): LocalDate {
        return DateFns.parse(str, pattern, Date(), options = obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        }).toLocalDate()
    }

    actual fun parseToLocalTime(str: String): LocalTime {
        return DateFns.parse(str, pattern, Date(), options = obj {
            locale = this@LocalDateTimeFormatter.locale.dateFnsLocale
        }).toLocalTime()
    }

    actual companion object {
        actual fun ofPattern(pattern: String, locale: Locale): LocalDateTimeFormatter {
            return LocalDateTimeFormatter(pattern, locale)
        }
    }

}
