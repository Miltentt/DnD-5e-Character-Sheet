package com.miltent.domain.model

data class Character(
    override val name: String,
    override val level: Int,
    override val race: Race,
    override val characterClass: CharacterClass,
    val baseStrength: Attribute,
    val baseDexterity: Attribute,
    val baseConstitution: Attribute,
    val baseIntelligence: Attribute,
    val baseWisdom: Attribute,
    val baseCharisma: Attribute,
    val temporaryStrModifier: Attribute,
    val temporaryDexModifier: Attribute,
    val temporaryConModifier: Attribute,
    val temporaryIntModifier: Attribute,
    val temporaryWisModifier: Attribute,
    val temporaryChaModifier: Attribute,
    val movementSpeed: MovementSpeed,
    val healthPoints: HealthPoints
): DashboardCharacter {

    interface Builder1stLevel {

        val baseStrength: Attribute
        val baseDexterity: Attribute
        val baseConstitution: Attribute
        val baseIntelligence: Attribute
        val baseWisdom: Attribute
        val baseCharisma: Attribute
        val race: Race
        val characterClass: CharacterClass
        val skillsIds: List<String>
        val specialAbility: List<SpecialAbility>

        fun baseInfo(
            name: String,
            race: Race,
            characterClass: CharacterClass,
            baseStrength: Attribute,
            baseDexterity: Attribute,
            baseConstitution: Attribute,
            baseIntelligence: Attribute,
            baseWisdom: Attribute,
            baseCharisma: Attribute,
        )

        fun skills(skillsIds: List<String>)

        fun specialAbility(vararg specialAbility: SpecialAbility)

        fun build(): Character
    }
}
