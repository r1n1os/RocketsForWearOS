package com.example.rocketsforwearos.presentation.rockets_list_screen

import com.example.rocketsforwearos.data.local_database.entities.relations.RocketAndHeight


data class RocketsListState(
    val isLoading: Boolean = false,
    val rocketsList: List<RocketAndHeight> = emptyList(),
    val error: String = ""
)
