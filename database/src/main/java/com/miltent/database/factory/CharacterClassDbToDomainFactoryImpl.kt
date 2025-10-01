package com.miltent.database.factory

import com.miltent.domain.model.CharacterClass
import javax.inject.Inject

class CharacterClassDbToDomainFactoryImpl @Inject constructor(): CharacterClassDbToDomainFactory {

    override fun createCharacterClass(
        level: Int,
        classIdentifier: String
    ): CharacterClass {
        return when (classIdentifier) {
            CharacterClass.Fighter.identifier -> CharacterClass.Fighter(level)
            CharacterClass.Ranger.identifier -> CharacterClass.Ranger(level)
            else -> throw IllegalArgumentException("Unknown character class: $classIdentifier")
        }
    }
}