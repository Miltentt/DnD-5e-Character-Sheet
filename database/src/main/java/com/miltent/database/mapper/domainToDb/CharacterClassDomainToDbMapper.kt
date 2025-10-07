package com.miltent.database.mapper.domainToDb

import com.miltent.core.utility.Mapper
import com.miltent.database.entities.character.CharacterClassEntity
import com.miltent.domain.model.CharacterClass
import javax.inject.Inject

class CharacterClassDomainToDbMapper @Inject constructor() :
    Mapper<CharacterClass, CharacterClassEntity> {
    override fun map(value: CharacterClass): CharacterClassEntity = CharacterClassEntity(
        characterClassIdentifier = value.identifier,
        level = value.level
    )
}