package com.example.rocketsforwearos.data.remote.dto

import com.example.rocketsforwearos.data.local_database.entities.payload_weights.PayloadWeightsEntity

data class PayloadWeight(
    val id: String,
    val kg: Float,
    val lb: Float,
    val name: String
) {
    fun toPayloadWeightEntity(rocketEntityId: Int): PayloadWeightsEntity {
        return PayloadWeightsEntity(
            id = id,
            kg = kg,
            lb = lb,
            name = name,
            rocketEntityId = rocketEntityId
        )
    }

    fun parsePayloadWeightListToPayloadWeightEntityList(
        rocketEntityId: Int,
        payloadWeightList: List<PayloadWeight>
    ): List<PayloadWeightsEntity> {
        return payloadWeightList.map { it.toPayloadWeightEntity(rocketEntityId) }
    }
}