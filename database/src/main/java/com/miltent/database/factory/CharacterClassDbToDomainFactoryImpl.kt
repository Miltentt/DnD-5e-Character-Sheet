package com.miltent.database.factory

import com.miltent.domain.model.CharacterClass
import javax.inject.Inject

class CharacterClassDbToDomainFactoryImpl @Inject constructor(): CharacterClassDbToDomainFactory {

    override fun createCharacterClass(
        level: Int,
        className: String
    ): CharacterClass {
        return when (className) {
            CharacterClass.Fighter.name -> CharacterClass.Fighter(level)
            else -> throw IllegalArgumentException("Unknown character class: $className")
        }
    }
}