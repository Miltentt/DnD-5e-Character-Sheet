package com.miltent.domain.model

sealed class CharacterClass {

    data object Fighter : CharacterClass()
}