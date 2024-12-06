package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class CoinInfoRetrofit(
    @SerializedName("Id")
    val id: String? = null,

    @SerializedName("FullName")
    val fullName: String? = null,

    @SerializedName("Name")
    val name: String? = null,

    @SerializedName("ImageUrl")
    val imageUrl: String? = null,

    @SerializedName("Url")
    val url: String? = null,
)