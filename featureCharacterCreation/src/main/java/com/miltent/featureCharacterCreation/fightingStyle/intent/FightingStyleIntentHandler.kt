package com.miltent.featureCharacterCreation.fightingStyle.intent

import com.miltent.core.intent.IntentHandler
import javax.inject.Inject

internal class FightingStyleIntentHandler @Inject constructor() : IntentHandler<FightingStyleIntent> {

    override suspend fun handle(intent: FightingStyleIntent) {
    }
}