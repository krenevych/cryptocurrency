package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoRetrofit? = CoinInfoRetrofit(),
//    @SerializedName("DISPLAY")
//    val dISPLAY: DISPLAY? = DISPLAY(),
//    @SerializedName("RAW")
//    val rAW: RAW? = RAW()
)