package com.example.rocketsforwearos.data.remote.dto

import com.example.rocketsforwearos.data.local_database.entities.height.HeightEntity

data class Height(
    val feet: Double,
    val meters: Double
) {
    fun toRocketEntity(rocketEntityId: Int): HeightEntity {
        return HeightEntity(
            id = 1,
            meters = meters,
            feet = feet,
            rocketEntityId = rocketEntityId
        )
    }
}