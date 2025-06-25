package com.miltent.core.useCase

import com.miltent.domain.model.Character
import com.miltent.domain.model.DashboardCharacter
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
    baseConstitution = 16,
    baseIntelligence = 9,
    baseCharisma = 12,
    baseStrength = 19,
    baseDexterity = 14,
    baseWisdom = 13,
    level = 7
)