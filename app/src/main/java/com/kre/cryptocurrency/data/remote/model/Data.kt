package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoRetrofit? = CoinInfoRetrofit(),

)