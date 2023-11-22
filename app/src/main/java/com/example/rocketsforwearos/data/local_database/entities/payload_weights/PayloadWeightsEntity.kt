package com.example.rocketsforwearos.data.local_database.entities.payload_weights

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PayloadWeightsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val kg: Float,
    val lb: Float,
    val rocketEntityId: Int
)
