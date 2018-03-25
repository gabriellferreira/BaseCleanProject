package br.com.gabrielferreira.baseclean.presentation.util.extension

import android.annotation.SuppressLint
import android.os.Build

fun isAboveOrEqualsLollipop(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
}

@SuppressLint("ObsoleteSdkInt")
fun isBelowLollipop(): Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
}

fun equalsLollipop(): Boolean {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP
}

fun equalsKitKat(): Boolean {
    return Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT
}