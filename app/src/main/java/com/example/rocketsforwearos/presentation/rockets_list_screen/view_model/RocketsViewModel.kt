package com.example.rocketsforwearos.presentation.rockets_list_screen.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rocketsforwearos.presentation.rockets_list_screen.RocketsListState
import com.example.rocketsforwearos.domain.use_case.get_rocket_list_use_case.GetRocketsListUseCase
import com.example.rocketsforwearos.domain.use_case.query_rockets_from_local_databse.QueryRocketsFromLocalDatabase
import com.example.rocketsforwearos.domain.use_case.save_rockets_into_local_database_use_case.SaveRocketsIntoLocalDatabaseUseCase
import com.example.rocketsforwearos.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(
    private val getRocketsListUseCase: GetRocketsListUseCase,
    private val saveRocketsIntoLocalDatabaseUseCase: SaveRocketsIntoLocalDatabaseUseCase,
    private val queryRocketsFromLocalDatabase: QueryRocketsFromLocalDatabase

) : ViewModel() {

    private val _rocketListState = mutableStateOf(RocketsListState())
    val state: State<RocketsListState> = _rocketListState

    init {
        queryRocketsOffline()
        getRocketsList()
    }

    private fun queryRocketsOffline() {
        queryRocketsFromLocalDatabase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _rocketListState.value =
                        RocketsListState(rocketsList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _rocketListState.value = RocketsListState(
                        error = result.message ?: "Unknown error occurred"
                    )
                }

                is Resource.Loading -> {
                    _rocketListState.value = RocketsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getRocketsList() {
        getRocketsListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    saveRocketsIntoLocalDatabaseUseCase(result.data ?: emptyList()).launchIn(
                        viewModelScope
                    )
                    queryRocketsOffline()
                }

                is Resource.Error -> {
                    _rocketListState.value = RocketsListState(
                        error = result.message ?: "Unknown error occurred"
                    )
                }

                is Resource.Loading -> {
                    _rocketListState.value = RocketsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}