package br.com.gabriellferreira.baseclean.presentation.util.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier.InternetConnectionType
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier.InternetConnectionType.*
import br.com.gabriellferreira.baseclean.presentation.util.extension.checkInternetConnection
import javax.inject.Inject

class DefaultInternetConnectionVerifier @Inject constructor(val context: Context) : InternetConnectionVerifier {

    override fun isConnectedToInternet() = context.checkInternetConnection()

    override fun getInternetConnectionType(): InternetConnectionType {
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            return getNetworkCapabilities(activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> WIFI
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> MOBILE_DATA
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> ETHERNET
                    else -> NO_CONNECTION
                }
            } ?: NO_CONNECTION
        }
    }
}