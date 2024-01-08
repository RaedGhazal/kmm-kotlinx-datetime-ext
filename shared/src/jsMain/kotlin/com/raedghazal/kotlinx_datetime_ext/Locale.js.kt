package com.raedghazal.kotlinx_datetime_ext

import kotlinx.browser.window

actual class Locale private constructor(val dateFnsLocale: DateFnsLocale) {
    actual companion object {
        actual fun default(): Locale {
            val language = window.navigator.language
            return forLanguageTag(language)
        }

        actual fun en(): Locale {
            return forLanguageTag("en-US")
        }

        actual fun forLanguageTag(languageTag: String): Locale {
            return DateFnsLocales.asDynamic()[languageTag.replace("-", "").replace("_", "")]
                .unsafeCast<DateFnsLocale?>()?.let { Locale(it) }
                ?: DateFnsLocales.asDynamic()[languageTag.split("-")[0].split("_")[0]]
                    .unsafeCast<DateFnsLocale?>()?.let { Locale(it) }
                ?: en()
        }
    }
}
