package com.example.rocketsforwearos.domain.repository

import com.example.rocketsforwearos.data.local_database.entities.relations.RocketAndHeight
import com.example.rocketsforwearos.data.local_database.entities.relations.RocketWithPayloadWeights
import com.example.rocketsforwearos.data.remote.dto.RocketDto


interface RocketsRepository {

    suspend fun getRockets(): List<RocketDto>

    suspend fun saveRocketsIntoLocalDatabase(rocketsDtoList: List<RocketDto>)

    suspend fun queryRocketListFromLocalDatabase(): List<RocketAndHeight>

    suspend fun queryRocketDetailsFromLocalDatabaseById(rocketId: String): RocketAndHeight

    suspend fun queryRocketDetailsWithPayloadWeightFromLocalDatabaseById(rocketId: String): RocketWithPayloadWeights
}