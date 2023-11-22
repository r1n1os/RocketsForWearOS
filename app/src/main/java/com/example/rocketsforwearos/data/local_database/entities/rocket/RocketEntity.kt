package com.example.rocketsforwearos.data.local_database.entities.rocket

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rocket")
data class RocketEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val isActive: Boolean,
    val costPerLaunch: Int,
    val successRatePct: Int,
    val firstFlight: String,
    val country: String,
    val company: String,
    val rocketName: String,
    val rocketType: String,
    val description: String,
    val flickrImage: String
)
