package com.miltent.database.entities.skills

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.skills.SkillTranslationEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SkillTranslationEntity(
   @PrimaryKey(autoGenerate = true)
    val id: Int,
    val skillId: String,
    val languageSuffix: String,
    val name: String,
) {
    companion object {
        const val TABLE_NAME = "SkillTranslation"
    }
}