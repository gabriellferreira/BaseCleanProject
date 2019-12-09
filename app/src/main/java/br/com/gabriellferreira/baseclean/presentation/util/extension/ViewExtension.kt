@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.presentation.util.extension

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.presentation.util.extension.ViewExtension.Companion.SNACK_BAR_MAX_LINES
import com.google.android.material.snackbar.Snackbar

class ViewExtension {
    companion object {
        const val SNACK_BAR_MAX_LINES = 5
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
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    (snackBar.view.findViewById(R.id.snackbar_text) as TextView?)?.maxLines = SNACK_BAR_MAX_LINES
    snackBar.show()
}