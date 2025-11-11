package com.miltent.domain.model

interface DashboardCharacter {
    val id: String
    val name: String
    val level: Int
    val race: Race
    val characterClass: CharacterClass
}