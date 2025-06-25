package com.miltent.core.event

interface EventHandler<in T: Event> {

    fun handle(event: T)
}