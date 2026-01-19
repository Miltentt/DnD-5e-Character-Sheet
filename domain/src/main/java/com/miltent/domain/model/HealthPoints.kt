package com.miltent.domain.model

import com.sun.jdi.Value


class HealthPoints (val max: Int, ){
    var temporary: Int = 0
        private set

    var current: Int = max
        private set

    private fun resetHealthPointsValue(){
        current = max
        temporary = 0
    }
    fun changeHealthPointsValue(action: HealthPointsAction, value: Int){
        when(action){

            HealthPointsAction.HEAL -> {
                current += value
                if(current > max) current = max
            }
            HealthPointsAction.ADD_TEMPORARY -> {
                if(value > temporary) temporary = value
            }
            HealthPointsAction.DAMAGE -> {
                if(value > temporary) {
                    current -= value - temporary
                    temporary = 0
                }else{
                    temporary -= value
                }
            }
            else -> throw Exception()
        }
    }

    companion object{
        fun makeFromData(max: Int, current: Int, temporary: Int): HealthPoints {
            return HealthPoints(max)
                    .apply {
                        changeHealthPointsValue(HealthPointsAction.DAMAGE, max - current)
                        changeHealthPointsValue(HealthPointsAction.ADD_TEMPORARY, temporary)
                    }
        }
    }
}