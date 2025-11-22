package com.miltent.featurecardbase.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
internal class CardBaseEventHandler @Inject constructor(): EventHandler<CardBaseEvent>()