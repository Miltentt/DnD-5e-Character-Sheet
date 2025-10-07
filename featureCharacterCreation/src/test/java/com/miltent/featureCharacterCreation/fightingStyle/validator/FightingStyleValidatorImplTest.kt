package com.miltent.featureCharacterCreation.fightingStyle.validator

import com.miltent.domain.model.SpecialAbility
import com.miltent.domain.model.SpecialAbilityType
import com.miltent.featureCharacterCreation.fightingStyle.validation.FightingStyleValidatorImpl
import com.miltent.featureCharacterCreation.fightingStyle.validation.ValidationError
import org.junit.Assert
import org.junit.Test

class FightingStyleValidatorImplTest {

    private var sut: FightingStyleValidatorImpl = FightingStyleValidatorImpl()

    @Test
    fun `validate returns null on non null fighting style`() {
        // Arrange
        val specialAbility =
            SpecialAbility(name = "Fighting Style", description = "A special ability", type = SpecialAbilityType.FightingStyle ,id = "")
        // Act
        val result = sut.isValid(specialAbility)
        // Assert
        Assert.assertEquals(null, result)
    }

    @Test
    fun `validate returns ValidationError on null fighting style`() {
        // Arrange
        // Act
        val result = sut.isValid(null)
        // Assert
        Assert.assertEquals(ValidationError.EmptyFightingStyle, result)
    }
}