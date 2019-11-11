@file:Suppress("unused")
package br.com.gabriellferreira.baseclean.presentation.util.extension

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.StringRes
import android.widget.Toast

fun Context.checkInternetConnection(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = cm.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isAvailable && activeNetworkInfo.isConnected
}

fun Context.displayToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.displayToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}