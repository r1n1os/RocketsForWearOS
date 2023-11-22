package com.example.rocketsforwearos.domain.use_case.get_rocket_list_use_case

import com.example.rocketsforwearos.data.remote.dto.RocketDto
import com.example.rocketsforwearos.domain.repository.RocketsRepository
import com.example.rocketsforwearos.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class GetRocketsListUseCase @Inject constructor(
    private val repository: RocketsRepository
) {
    operator fun invoke(): Flow<Resource<List<RocketDto>>> = flow {
        try {
            emit(Resource.Loading())
            val rockets = repository.getRockets()
            emit(Resource.Success(rockets))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Could not reach server. Check your internet connection"))
        }
    }.flowOn(Dispatchers.IO)
}