package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("Data")
    val coins: List<Data>? = listOf(),
//    @SerializedName("HasWarning")
//    val hasWarning: Boolean? = false,
//    @SerializedName("Message")
//    val message: String? = "",
//    @SerializedName("MetaData")
//    val metaData: MetaData? = MetaData(),
//    @SerializedName("RateLimit")
//    val rateLimit: RateLimit? = RateLimit(),
//    @SerializedName("SponsoredData")
//    val sponsoredData: List<Any?>? = listOf(),
//    @SerializedName("Type")
//    val type: Int? = 0
)