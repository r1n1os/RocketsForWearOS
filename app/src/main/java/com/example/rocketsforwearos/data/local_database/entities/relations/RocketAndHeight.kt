package com.example.rocketsforwearos.data.local_database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.rocketsforwearos.data.local_database.entities.height.HeightEntity
import com.example.rocketsforwearos.data.local_database.entities.rocket.RocketEntity

data class RocketAndHeight(
    @Embedded val rocketEntity: RocketEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketEntityId"
    )
    val height: HeightEntity?
)

