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
            uiAttributes = Attributes.uiAttributes,
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
            uiAttributes = Attributes.uiAttributes,
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
            uiAttributes = Attributes.uiAttributes,
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
            uiAttributes = Attributes.uiAttributes,
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyClass), result)
    }
    @Test
    fun `should return list with ValidationError EmptyAttribute when statistic is null`(){
        // Arrange
        // Act
        val resultStr = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.STR] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.STR)), resultStr)
        // Act
        val resultDex = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.DEX] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.DEX)), resultStr)
        // Act
        val resultCon = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.CON] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.CON)), resultStr)
        // Act
        val resultInt = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.INT] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.INT)), resultStr)
        // Act
        val resultWis = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.WIS] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.WIS)), resultStr)
        // Act
        val resultCha = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.CHA] = null },
        )
        // Assert
        assertEquals(listOf(ValidationError.EmptyAttribute(StatisticType.CHA)), resultStr)
    }

    @Test
    fun `should return list with ValidationError AttributeOutOfRange when statistic is over 18 or below 3`() {
        // Arrange
        // Act
        val resultStr = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.STR] = Attribute(2) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.STR)), resultStr)

        // Act
        val resultDex = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.DEX] = Attribute(20) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.DEX)), resultDex)
        // Act
        val resultCon = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.CON] = Attribute(2) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.CON)), resultCon)
        // Act
        val resultInt = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.INT] = Attribute(20) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.INT)), resultInt)
        // Act
        val resultWis = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.WIS] = Attribute(1) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.WIS)), resultWis)
        // Act
        val resultCha = sut.areFieldsValid(
            name = "name",
            race = Race.Dwarf,
            characterClass = CharacterClass.Fighter(8),
            uiAttributes = Attributes.uiAttributes.toMutableMap()
                .apply { this[StatisticType.CHA] = Attribute(20) },
        )
        // Assert
        assertEquals(listOf(ValidationError.AttributeOutOfRange(StatisticType.CHA)), resultCha)
    }
}