package com.example.rocketsforwearos.data.local_database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.rocketsforwearos.data.local_database.entities.payload_weights.PayloadWeightsEntity
import com.example.rocketsforwearos.data.local_database.entities.rocket.RocketEntity

data class RocketWithPayloadWeights(
    @Embedded val rocketEntity: RocketEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketEntityId"
    )
    val payloadWeightsEntityList: List<PayloadWeightsEntity>
) {
}