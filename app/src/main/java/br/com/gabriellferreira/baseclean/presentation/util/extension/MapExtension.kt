package br.com.gabriellferreira.baseclean.presentation.util.extension

fun <K, V> Map<out K, V>.getOrDefaultCompat(key: K, defaultValue: V): V {
    if (this.containsKey(key)) {
        return this[key] ?: defaultValue
    }
    return defaultValue
}

fun <K, V> Map<out K, V>.getOrNullableCompat(key: K): V? {
    if (this.containsKey(key)) {
        return this[key]
    }
    return null
}