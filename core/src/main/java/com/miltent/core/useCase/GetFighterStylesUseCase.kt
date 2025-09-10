package com.miltent.core.useCase

import com.miltent.domain.model.SpecialAbility.Companion.defaultFighterFightingStyles
import javax.inject.Inject

class GetFighterStylesUseCase @Inject constructor() {

    operator fun invoke() = defaultFighterFightingStyles
}