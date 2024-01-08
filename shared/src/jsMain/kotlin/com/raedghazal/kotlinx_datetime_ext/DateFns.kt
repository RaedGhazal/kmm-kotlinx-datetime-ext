package com.raedghazal.kotlinx_datetime_ext

import kotlin.js.Date

external class DateFnsLocale

external interface FormatOptions {
    var locale: DateFnsLocale
}

external interface ParseOptions {
    var locale: DateFnsLocale
}

@JsModule("date-fns")
external object DateFns {
    fun format(date: Date, pattern: String, options: FormatOptions= definedExternally): String
    fun parse(dateStr: String, pattern: String, baseDate: Date, options: ParseOptions = definedExternally): Date
}

@JsModule("date-fns/locale")
external object DateFnsLocales
