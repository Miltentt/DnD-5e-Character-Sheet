package com.miltent.core.intent

interface IntentHandler<T: Intent> {

     fun handle(intent: T)
}