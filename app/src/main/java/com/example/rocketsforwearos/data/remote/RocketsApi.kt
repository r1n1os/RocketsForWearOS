package com.example.rocketsforwearos.data.remote

import com.example.rocketsforwearos.data.remote.dto.RocketDto
import retrofit2.http.GET

interface RocketsApi {

    @GET("rockets/")
    suspend fun getRocketList(): List<RocketDto>
}