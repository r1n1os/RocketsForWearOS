package com.example.rocketsforwearos.domain.use_case.save_rockets_into_local_database_use_case

import com.example.rocketsforwearos.data.remote.dto.RocketDto
import com.example.rocketsforwearos.domain.repository.RocketsRepository
import com.example.rocketsforwearos.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class SaveRocketsIntoLocalDatabaseUseCase @Inject constructor(
    private val repository: RocketsRepository
){
    operator fun invoke(rocketDtoList: List<RocketDto>): Flow<Resource<String>> = flow {
        try {
            repository.saveRocketsIntoLocalDatabase(rocketDtoList)
            emit(Resource.Success("Succeed"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Something went wrong with saving data into local database"))
        }
    }.flowOn(Dispatchers.IO)
}