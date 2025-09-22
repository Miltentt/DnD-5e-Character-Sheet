package com.miltent.database.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class SkillTypeConverters {

    private val moshi = Moshi.Builder().build()
    private val type = Types.newParameterizedType(List::class.java,String::class.java)
    private val adapter = moshi.adapter<List<String>>(type)

    @TypeConverter
    fun fromListOfString(list : List<String>?): String{
        return adapter.toJson(list) ?: ""
    }

    @TypeConverter
    fun toListOfString(json : String): List<String>{
        return adapter.fromJson(json) ?: emptyList()
    }
}
