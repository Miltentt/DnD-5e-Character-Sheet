package com.miltent.database.entities.specialAbility

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.specialAbility.SpecialAbilityTranslationEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SpecialAbilityTranslationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val specialAbilityId: String,
    val languageSuffix: String,
    val name: String,
    val description: String,
) {
    companion object {
        const val TABLE_NAME = "SpecialAbilityTranslation"
    }
}