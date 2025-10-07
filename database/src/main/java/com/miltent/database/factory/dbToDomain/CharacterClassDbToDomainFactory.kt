package com.miltent.database.factory.dbToDomain

import com.miltent.domain.model.CharacterClass

interface CharacterClassDbToDomainFactory {

    fun createCharacterClass(level: Int, classIdentifier: String): CharacterClass
}