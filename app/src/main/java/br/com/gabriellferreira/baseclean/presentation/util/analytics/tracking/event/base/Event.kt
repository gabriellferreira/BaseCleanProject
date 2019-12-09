package br.com.gabriellferreira.baseclean.presentation.util.analytics.tracking.event.base

import br.com.gabriellferreira.baseclean.presentation.util.analytics.AnalyticsManager
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier
import br.com.gabriellferreira.baseclean.presentation.util.connection.InternetConnectionVerifier.InternetConnectionType.*
import br.com.gabriellferreira.baseclean.presentation.util.extension.TAG

abstract class Event {

    abstract val name: String
    private val params: MutableMap<String, String> = mutableMapOf()

    fun addParam(name: String, value: String) = this.apply {
        params[name] = value
    }

    fun send() {
        AnalyticsManager.trackEvent(event = this)
    }

    override fun toString(): String {
        return "${
        this.TAG}(name='${
        this.name}', params={${
        this.params.map { "${it.key}=${it.value}" }.toString().drop(1).dropLast(1)}})"
    }

    object Params {
        const val PARAM_REACHABILITY = "REACHABILITY"
        const val PARAM_MSISDN = "MSISDN"
        const val PARAM_ORIGIN = "ORIGIN"

        enum class Boolean {
            TRUE, FALSE
        }

        enum class Reachability {
            WIFI, OFFLINE, WWAN, ETHERNET
        }

        enum class Origin {
            SPLASH, NONE
        }

        enum class AssetType {
            IMAGE, VIDEO
        }
    }

    fun getReachability(connectionType: InternetConnectionVerifier.InternetConnectionType): Params.Reachability =
            when (connectionType) {
                MOBILE_DATA -> {
                    Params.Reachability.WWAN
                }
                WIFI -> {
                    Params.Reachability.WIFI
                }
                ETHERNET -> {
                    Params.Reachability.ETHERNET
                }
                NO_CONNECTION -> {
                    Params.Reachability.OFFLINE
                }
            }
}