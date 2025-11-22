package com.miltent.featurecardbase.characterCard.intent

import com.miltent.core.intent.IntentHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CharacterCardIntentHandler @Inject constructor() : IntentHandler<CharacterCardIntent> {
    override suspend fun handle(intent: CharacterCardIntent) {
    }
}