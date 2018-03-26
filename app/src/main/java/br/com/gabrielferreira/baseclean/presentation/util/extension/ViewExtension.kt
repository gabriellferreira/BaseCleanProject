@file:Suppress("unused")
package br.com.gabrielferreira.baseclean.presentation.util.extension

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import br.com.gabrielferreira.baseclean.presentation.util.extension.ViewExtension.Companion.SNACK_BAR_MAX_LINES

class ViewExtension {
    companion object {
        val SNACK_BAR_MAX_LINES = 5
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.becomeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.disable() {
    this.isEnabled = false
}

fun View.enable() {
    this.isEnabled = true
}

fun View.displayToast(@StringRes message: Int) {
    context?.displayToast(message)
}

fun View.displayToast(message: String) {
    context?.displayToast(message)
}

fun View.displaySnackbar(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun View.displaySnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun View.displayLongSnackbar(@StringRes message: Int) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    (snackbar.view.findViewById(android.support.design.R.id.snackbar_text) as TextView?)?.maxLines = SNACK_BAR_MAX_LINES
    snackbar.show()
}