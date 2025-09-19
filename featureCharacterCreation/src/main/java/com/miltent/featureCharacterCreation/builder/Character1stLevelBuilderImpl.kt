package com.miltent.featureCharacterCreation.builder

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import com.miltent.domain.model.Skill
import com.miltent.domain.model.SpecialAbility
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Character1stLevelBuilderImpl @Inject constructor() : Character.Builder1stLevel {

    private var name: String = ""
    override var race: Race = Race.Dwarf
    private set
    override var characterClass: CharacterClass = CharacterClass.Fighter(1)
    private set
    override var baseStrength: Attribute = Attribute(0)
        private set
    override var baseDexterity: Attribute = Attribute(0)
        private set
    override var baseConstitution: Attribute = Attribute(0)
        private set
    override var baseIntelligence: Attribute = Attribute(0)
        private set
    override var baseWisdom: Attribute = Attribute(0)
        private set
    override var baseCharisma: Attribute = Attribute(0)
        private set

    var skills: List<Skill> = emptyList()
    private var specialAbility: List<SpecialAbility> = emptyList()

    override fun baseInfo(
        name: String,
        race: Race,
        characterClass: CharacterClass,
        baseStrength: Attribute,
        baseDexterity: Attribute,
        baseConstitution: Attribute,
        baseIntelligence: Attribute,
        baseWisdom: Attribute,
        baseCharisma: Attribute
    ) {
        this.name = name
        this.race = race
        this.characterClass = characterClass
        this.baseStrength = baseStrength
        this.baseDexterity = baseDexterity
        this.baseConstitution = baseConstitution
        this.baseIntelligence = baseIntelligence
        this.baseWisdom = baseWisdom
        this.baseCharisma = baseCharisma
    }

    override fun skills(skills: List<Skill>) {
        this.skills = skills
    }

    override fun specialAbility(vararg specialAbility: SpecialAbility) {
        this.specialAbility = this.specialAbility + specialAbility.toList()
    }

    override fun build(): Character {
        return Character(
            name = name,
            level = 1,
            race = race,
            characterClass = characterClass,
            baseStrength = baseStrength + race.extraModifierStrength,
            baseDexterity = baseDexterity + race.extraModifierDex,
            baseConstitution = baseConstitution + race.extraModifierCon,
            baseIntelligence = baseIntelligence + race.extraModifierInt,
            baseWisdom = baseWisdom + race.extraModifierWis,
            baseCharisma = baseCharisma + race.extraModifierCha,
            temporaryChaModifier = Attribute(0),
            temporaryConModifier = Attribute(0),
            temporaryDexModifier = Attribute(0),
            temporaryIntModifier = Attribute(0),
            temporaryStrModifier = Attribute(0),
            temporaryWisModifier = Attribute(0),
            movementSpeed = MovementSpeed(
                race.movementSpeed.value
                        + characterClass.movementSpeedModifier.value
                        + specialAbility.sumOf { it.movementSpeedModifier.value }
            ),
            skills = skills
        )
    }
}