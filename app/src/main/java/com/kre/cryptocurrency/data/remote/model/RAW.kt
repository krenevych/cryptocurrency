package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class RAW(
    @SerializedName("USD")
    val uSD: USDX? = USDX()
)