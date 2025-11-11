package com.miltent.featureCharacterCreation.baseInfo.validator

import com.miltent.domain.model.Attribute
import com.miltent.domain.model.Attributes
import com.miltent.domain.model.CharacterClass
import com.miltent.domain.model.Race
import com.miltent.domain.model.StatisticType
import org.junit.Test
import org.junit.Assert.assertEquals

class BaseInfoValidatorImplTest {

    val sut: BaseInfoValidatorImpl = BaseInfoValidatorImpl()

    @Test
    fun `should return emptyList of ValidationError when all fields are valid`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes(),
        )
        // Assert
        assertEquals(emptyList<ValidationError>(), result)
    }

    @Test
    fun `should return ValidationError EmptyName when name is empty`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes(),
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyName), result)
    }

    @Test
    fun `should return ValidationError EmptyRace when race is null`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = null,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes(),
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyRace), result)
    }

    @Test
    fun `should return ValidationError EmptyClass when characterClass is null`() {
        // Arrange
        // Act
        val result = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = null,
            attributes = Attributes(),
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyClass), result)
    }

    @Test
    fun `should return ValidationError StatisticTooHigh when statistic is over 18`() {
        // Arrange
        // Act
        val resultStr = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.STR, Attribute(1)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.STR)), resultStr)

        // Act
        val resultDex = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.DEX, Attribute(19)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.DEX)), resultDex)
        // Act
        val resultCon = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.CON, Attribute(1)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.CON)), resultCon)
        // Act
        val resultInt = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.INT, Attribute(19)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.INT)), resultInt)
        // Act
        val resultWis = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.WIS, Attribute(1)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.WIS)), resultWis)
        // Act
        val resultCha = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            attributes = Attributes().updateAttribute(StatisticType.CHA, Attribute(19)),
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.CHA)), resultCha)
    }
}