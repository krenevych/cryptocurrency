package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("Data")
    val coins: List<CoinInfoData>? = listOf(),
)