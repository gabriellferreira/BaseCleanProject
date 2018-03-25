package br.com.gabrielferreira.baseclean.presentation.util.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import br.com.gabrielferreira.baseclean.presentation.util.extension.checkInternetConnection
import javax.inject.Inject

class DefaultInternetConnectionVerifier @Inject constructor(val context: Context) : InternetConnectionVerifier {

    override fun isConnectedToInternet() = context.checkInternetConnection()

    override fun getInternetConnectionType(): InternetConnectionVerifier.InternetConnectionType {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo

        return when (activeNetwork.type) {
            TYPE_WIFI, TYPE_WIMAX -> InternetConnectionVerifier.InternetConnectionType.WIFI
            TYPE_MOBILE -> InternetConnectionVerifier.InternetConnectionType.MOBILE_DATA
            else -> InternetConnectionVerifier.InternetConnectionType.NO_CONNECTION
        }
    }
}