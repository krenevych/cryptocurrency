package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class CoinPrice(
    @SerializedName("EUR")
    val eur: Double?,
    @SerializedName("JPY")
    val jpy: Double?,
    @SerializedName("USD")
    val usd: Double?
)