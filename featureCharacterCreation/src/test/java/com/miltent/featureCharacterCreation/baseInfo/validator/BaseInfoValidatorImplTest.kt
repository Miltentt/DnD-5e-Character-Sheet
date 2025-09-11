package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import org.junit.Test
import org.junit.Assert.assertEquals

class BaseInfoValidatorImplTest {

    val sut: BaseInfoValidatorImpl = BaseInfoValidatorImpl()

    @Test
    fun `should return null when all fields are valid`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(null, result)
    }

    @Test
    fun `should return ValidationError EmptyName when name is empty`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.EmptyName, result)
    }

    @Test
    fun `should return ValidationError EmptyRace when race is null`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = null,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.EmptyRace, result)
    }

    @Test
    fun `should return ValidationError EmptyClass when characterClass is null`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = null,
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.EmptyClass, result)
    }

    @Test
    fun `should return ValidationError StatisticTooHigh when statistic is over 18`() {
        // Arrange
        // Act
        val resultStr = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(19),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.StrengthTooHigh, resultStr)

        // Act
        val resultDex = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(19),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.DexterityTooHigh, resultDex)
        // Act
        val resultCon = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(19),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.ConstitutionTooHigh, resultCon)
        // Act
        val resultInt = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(19),
            wisdom = Attribute(10),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.IntelligenceTooHigh, resultInt)
        // Act
        val resultWis = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(19),
            charisma = Attribute(10),
        )
        // Assert
        assertEquals(ValidationError.WisdomTooHigh, resultWis)
        // Act
        val resultCha = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            strength = Attribute(10),
            dexterity = Attribute(10),
            constitution = Attribute(10),
            intelligence = Attribute(10),
            wisdom = Attribute(10),
            charisma = Attribute(19),
        )
        // Assert
        assertEquals(ValidationError.CharismaTooHigh, resultCha)
    }
}