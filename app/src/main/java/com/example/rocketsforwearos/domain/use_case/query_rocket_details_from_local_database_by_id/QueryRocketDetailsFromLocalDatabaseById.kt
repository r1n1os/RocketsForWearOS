package com.example.rocketsforwearos.domain.use_case.query_rocket_details_from_local_database_by_id

import com.example.rocketsforwearos.data.local_database.entities.relations.RocketAndHeight
import com.example.rocketsforwearos.domain.repository.RocketsRepository
import com.example.rocketsforwearos.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class QueryRocketDetailsFromLocalDatabaseById @Inject constructor(
    private val repository: RocketsRepository
) {
    operator fun invoke(rocketId: String): Flow<Resource<RocketAndHeight>> = flow {
        try {
            val rocketsList = repository.queryRocketDetailsFromLocalDatabaseById(rocketId)
            emit(Resource.Success(rocketsList))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Something went wrong with retrieving data from local database"))
        }
    }.flowOn(Dispatchers.IO)
}