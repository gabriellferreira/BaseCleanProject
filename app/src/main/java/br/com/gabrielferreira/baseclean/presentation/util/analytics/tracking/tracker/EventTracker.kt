package br.com.gabrielferreira.baseclean.presentation.util.analytics.tracking.tracker

import br.com.gabrielferreira.baseclean.presentation.util.analytics.tracking.event.base.Event

interface EventTracker {

    fun track(event: Event)
}
