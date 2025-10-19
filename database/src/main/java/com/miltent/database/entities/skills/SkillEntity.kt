package com.miltent.database.entities.skills

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.miltent.database.entities.skills.SkillEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SkillEntity(
    @ColumnInfo(name = "skillId")
    @PrimaryKey
    val id: String,
    val statisticType: String
) {
    companion object {
        const val TABLE_NAME = "Skills"
    }
}
