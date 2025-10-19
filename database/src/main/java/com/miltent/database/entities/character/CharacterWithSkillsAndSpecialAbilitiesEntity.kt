package com.miltent.database.entities.character

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.miltent.database.entities.junctionTables.CharacterSkillCrossJunction
import com.miltent.database.entities.junctionTables.CharacterSpecialAbilityJunction
import com.miltent.database.entities.skills.SkillEntity
import com.miltent.database.entities.specialAbility.SpecialAbilityEntity

data class CharacterWithSkillsAndSpecialAbilitiesEntity(
    @Embedded
    val character: CharacterEntity,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "skillId",
        associateBy = Junction(CharacterSkillCrossJunction::class)
    )
    val skills: List<SkillEntity>,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "specialAbilityId",
        associateBy = Junction(CharacterSpecialAbilityJunction::class)
    )
    val specialAbilities: List<SpecialAbilityEntity>
)