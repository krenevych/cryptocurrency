package com.kre.cryptocurrency.data.remote.model


import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class CoinRawData (
    @SerializedName("RAW")
    val jsonObject: JsonObject? = null
)