package com.miltent.designsystem.formatter

import com.miltent.domain.model.CharacterClass
import kotlin.reflect.KClass
import com.miltent.resources.R as ResR

object CharacterClassFormatter {

    fun formatCharacterClass(characterClass: CharacterClass): Int =
        when (characterClass) {
            CharacterClass.Fighter::class -> ResR.string.class_fighter
            CharacterClass.Ranger::class -> ResR.string.class_ranger
            else -> ResR.string.unknown_error
        }
}