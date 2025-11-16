package com.miltent.database.domainToDb

import com.miltent.database.entities.specialAbility.SpecialAbilityEntity
import com.miltent.domain.model.SpecialAbilityType
import java.util.UUID

class SpecialAbilityEntityFactory {
    companion object{
        fun createEmptyFightingStyleSpecialAbilityEntity() = SpecialAbilityEntity(
            id = UUID.randomUUID().toString(),
            type = SpecialAbilityType.FightingStyle.value,
            strengthModifier = 0,
            dexterityModifier = 0,
            charismaModifier = 0,
            constitutionModifier = 0,
            intelligenceModifier = 0,
            wisdomModifier = 0,
            movementSpeedModifier = 0.0,
            armorClassModifier = 0
        )
        private fun someSpecialAbilities(): List<SpecialAbilityEntity>{
            val list = mutableListOf<SpecialAbilityEntity>()
            repeat(10){
                list += createEmptyFightingStyleSpecialAbilityEntity()
            }
            return list
        }
        val someSpecialAbilities = someSpecialAbilities()
    }
}