package com.miltent.featurecardbase.intent

import com.miltent.core.intent.IntentHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CardBaseIntentHandler @Inject constructor() : IntentHandler<CardBaseIntent> {
    override suspend fun handle(intent: CardBaseIntent) {
        TODO("Not yet implemented")
    }
}