package com.miltent.core.useCase

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Character
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.DashboardCharacter
import com.miltent.domain.model.MovementSpeed
import com.miltent.domain.model.Race
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetDashBoardCharactersUseCase @Inject constructor() {

    operator fun invoke(): Flow<List<DashboardCharacter>> = flowOf(listOf(mockCharacter))
}


// TODO to be removed when we base characters on DB
val mockCharacter = Character(
    name = "Tul-Duru",
    race = Race.Dwarf,
    baseConstitution = Attribute(0),
    baseIntelligence = Attribute(0),
    baseCharisma = Attribute(0),
    baseStrength = Attribute(0),
    baseDexterity = Attribute(0),
    baseWisdom = Attribute(0),
    level = 8,
    temporaryChaModifier = Attribute(0),
    temporaryConModifier = Attribute(0),
    temporaryDexModifier = Attribute(0),
    temporaryIntModifier = Attribute(0),
    temporaryStrModifier = Attribute(0),
    temporaryWisModifier = Attribute(0),
    movementSpeed = MovementSpeed(0.0),
    characterClass = CharacterClass.Fighter(8)
)