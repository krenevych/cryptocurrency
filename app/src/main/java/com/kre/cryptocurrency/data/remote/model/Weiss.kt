package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class Weiss(
    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String? = null,
    @SerializedName("Rating")
    val rating: String? = null,
    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String? = null
)