package com.example.rocketsforwearos.data.local_database.type_converters

import androidx.room.TypeConverter
import com.example.rocketsforwearos.data.local_database.entities.height.HeightEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeightConverter {

    @TypeConverter
    fun fromStringToHeight(value: String): HeightEntity? {
        return Gson().fromJson(value, object : TypeToken<HeightEntity>() {}.type)
    }

    @TypeConverter
    fun fromHeightToString(heightEntity: HeightEntity): String = Gson().toJson(heightEntity)
}