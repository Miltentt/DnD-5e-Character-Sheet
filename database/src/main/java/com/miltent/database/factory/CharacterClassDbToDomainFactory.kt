package com.miltent.database.factory

import com.miltent.domain.model.CharacterClass

interface CharacterClassDbToDomainFactory {

    fun createCharacterClass(level: Int, classIdentifier: String): CharacterClass
}