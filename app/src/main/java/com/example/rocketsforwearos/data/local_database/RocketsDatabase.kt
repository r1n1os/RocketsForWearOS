package com.example.rocketsforwearos.data.local_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rocketsforwearos.data.local_database.entities.height.HeightEntity
import com.example.rocketsforwearos.data.local_database.entities.payload_weights.PayloadWeightsEntity
import com.example.rocketsforwearos.data.local_database.entities.rocket.RocketDao
import com.example.rocketsforwearos.data.local_database.entities.rocket.RocketEntity
import com.example.rocketsforwearos.data.local_database.type_converters.HeightConverter


@Database(
    entities = [RocketEntity::class, HeightEntity::class, PayloadWeightsEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(HeightConverter::class)
abstract class RocketsDatabase : RoomDatabase() {
    abstract val dao: RocketDao


    fun deleteAll() {
        clearAllTables()
    }
}