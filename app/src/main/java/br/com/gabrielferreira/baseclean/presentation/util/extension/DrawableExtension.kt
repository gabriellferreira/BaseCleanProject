package br.com.gabrielferreira.baseclean.presentation.util.extension

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.graphics.drawable.DrawableCompat

@SuppressLint("NewApi")
fun Drawable.setDrawableTint(color: Int) {
    when {
        isAboveOrEqualsLollipop() -> setTintList(ColorStateList.valueOf(color))
        equalsKitKat() -> DrawableCompat.wrap(this).mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN)
        else -> DrawableCompat.setTintList(DrawableCompat.wrap(this).mutate(), ColorStateList.valueOf(color))
    }
}