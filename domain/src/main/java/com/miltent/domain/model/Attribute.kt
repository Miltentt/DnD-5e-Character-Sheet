package com.miltent.domain.model

@JvmInline
value class Attribute(val value: Int) {

    infix operator fun plus(other: Attribute): Attribute = Attribute(this.value + other.value)

    infix operator fun plus(other: Int): Attribute = Attribute(this.value + value)

    fun calculateModifier(temporaryModifier: Attribute = Attribute(0)): Int = ((this + temporaryModifier).value - 10) / 2

    companion object {
        fun fromString(value: String): Attribute = Attribute(value.toIntOrNull() ?: 0)
    }
}