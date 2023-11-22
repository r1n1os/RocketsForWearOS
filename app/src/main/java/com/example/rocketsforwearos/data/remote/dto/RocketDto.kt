package com.example.rocketsforwearos.data.remote.dto

import com.example.rocketsforwearos.data.local_database.entities.rocket.RocketEntity
import com.google.gson.annotations.SerializedName

data class RocketDto(
    val active: Boolean,
    val boosters: Int,
    val company: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int,
    val country: String,
    val description: String,
    val diameter: Diameter,
    val engines: Engines,
    @SerializedName("first_flight")
    val firstFlight: String,
    @SerializedName("first_stage")
    val firstStage: FirstStage,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    val height: Height,
    val id: Int,
    @SerializedName("landing_legs")
    val landingLegs: LandingLegs,
    val mass: Mass,
    @SerializedName("payload_weights")
    val payloadWeights: List<PayloadWeight>,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("second_stage")
    val secondStage: SecondStage,
    val stages: Int,
    @SerializedName("success_rate_pct")
    val successRatePct: Int,
    val wikipedia: String
) {
    fun toRocketEntity(): RocketEntity {
        return RocketEntity(
            id = id,
            isActive = active,
            costPerLaunch = costPerLaunch,
            successRatePct = successRatePct,
            firstFlight = firstFlight,
            country = country,
            company = company,
            rocketName = rocketName,
            rocketType = rocketType,
            description = description,
            flickrImage = flickrImages.first()
        )
    }
}

