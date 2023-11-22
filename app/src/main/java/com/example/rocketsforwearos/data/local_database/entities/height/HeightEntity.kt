package com.example.rocketsforwearos.data.local_database.entities.height

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeightEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val meters: Double,
    val feet: Double,
    val rocketEntityId: Int
)