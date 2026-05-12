package com.miltent.domain.model

data class CharacterDetailed(
    val character: Character,
    val skills: List<Skill>,
    val specialAbilities: List<SpecialAbility>
){
    fun getSkillsWithModifier(): List<SkillWithModifier> =
        skills.map { skill -> SkillWithModifier(
            id = skill.id,
            name = skill.name,
            modifier = with(skill.statisticType){
                val attribute = character.baseAttributes.values[this] ?: Attribute(Attribute.BASE_VALUE)
                val temporaryModifier = character.temporaryAttributes.values[this]  ?: Attribute(
                    Attribute.BASE_MODIFIER_VALUE)
                attribute.calculateModifier(temporaryModifier)
            }
        ) }
}