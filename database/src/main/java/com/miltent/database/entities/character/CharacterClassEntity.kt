package com.miltent.database.entities.character

import androidx.annotation.Keep

@Keep
data class CharacterClassEntity(
    val level: Int,
    val characterClassIdentifier: String,
)