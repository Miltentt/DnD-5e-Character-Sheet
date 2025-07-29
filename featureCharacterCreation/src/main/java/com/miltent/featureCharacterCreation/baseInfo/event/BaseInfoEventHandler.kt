package com.miltent.featureCharacterCreation.baseInfo.event

import com.miltent.core.event.EventHandler
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class BaseInfoEventHandler @Inject constructor(): EventHandler<BaseInfoEvent>()