package com.miltent.core.intent

interface IntentHandler<T: Intent> {

     suspend fun handle(intent: T)
}