package com.miltent.domain.model


class HealthPoints (val max: Int){
    var temporary: Int = 0
        private set
    var current: Int = max
        private set

    fun damage(damage:Int) {
        if(damage > temporary) {
            current -= damage - temporary
            temporary = 0
        }else{
            temporary -= damage
        }
    }
    fun heal(heal:Int) {
        current += heal
        if(current > max) current = max
    }
    fun newTemporary(new: Int){
        if(new > temporary) temporary = new
    }

    companion object{
        fun makeFromData(max: Int, current: Int, temporary: Int): HealthPoints {
            return HealthPoints(max)
                    .apply {
                        newTemporary(temporary)
                        damage(max - current)
                    }
        }
    }
}