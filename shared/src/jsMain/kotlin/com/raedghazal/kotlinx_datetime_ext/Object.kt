package com.raedghazal.kotlinx_datetime_ext

/**
 * A helper function to create a JS object of given external type.
 */
inline fun <T> obj(init: T.() -> Unit): T {
    return (js("{}").unsafeCast<T>()).apply(init)
}
