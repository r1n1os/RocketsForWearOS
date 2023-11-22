package com.example.rocketsforwearos.data.remote.dto

data class FirstStage(
    val burn_time_sec: Int,
    val engines: Double,
    val fuel_amount_tons: Double,
    val reusable: Boolean,
)