package br.com.gabriellferreira.baseclean.presentation.util.analytics.tracking.tracker

import br.com.gabriellferreira.baseclean.presentation.util.analytics.tracking.event.base.Event

interface EventTracker {

    fun track(event: Event)
}
