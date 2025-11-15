package com.miltent.featureCharacterCreation.builder

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.HealthPoints
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.StatisticType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Character1stLevelBuilderImpl @Inject constructor() : Character.Builder1stLevel {

    private var name: String = ""
    override var race: Race = Race.Dwarf
    private set
    override var characterClass: CharacterClass = CharacterClass.Fighter(1)
    private set
    override var baseAttributes: Attributes = Attributes()
        private set
     override var skillsIds: List<Int> = emptyList()
        private set
     override var specialAbility: List<SpecialAbility> = emptyList()
         private set

    override fun baseInfo(
        name: String,
        race: Race,
        characterClass: CharacterClass,
        baseAttributes: Attributes
    ) {
        this.name = name
        this.race = race
        this.characterClass = characterClass
        this.baseAttributes = baseAttributes
    }

    override fun skills(skillsIds: List<Int>) {
        this.skillsIds = skillsIds
    }

    override fun specialAbility(vararg specialAbility: SpecialAbility) {
        this.specialAbility = this.specialAbility + specialAbility.toList()
    }

    override fun build(): Character {
        val hp = baseAttributes.values.getValue(StatisticType.CON).calculateModifier() + characterClass.hitDie
        return Character(
            name = name,
            level = 1,
            race = race,
            characterClass = characterClass,
            baseAttributes = baseAttributes.addToAttributes(race.extraModifiers),
            temporaryAttributes = Attributes(0),
            movementSpeed = MovementSpeed(
                race.movementSpeed.value
                        + characterClass.movementSpeedModifier.value
                        + specialAbility.sumOf { it.movementSpeedModifier.value }
            ),
            healthPoints = HealthPoints(hp)
        )
    }
}