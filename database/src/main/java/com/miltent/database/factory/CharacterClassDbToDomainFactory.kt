package com.miltent.database.factory

import com.miltent.domain.model.CharacterClass

interface CharacterClassDbToDomainFactory {

    fun createCharacterClass(level: Int, className: String): CharacterClass
}