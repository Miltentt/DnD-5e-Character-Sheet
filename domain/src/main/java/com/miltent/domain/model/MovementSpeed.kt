package com.miltent.domain.model

@JvmInline
value class MovementSpeed(val value: Double) {
    companion object{
        const val BASE_MOVEMENT_SPEED = 9.0
    }
}