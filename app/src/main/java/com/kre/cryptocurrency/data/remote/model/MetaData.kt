package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("Count")
    val count: Int? = null
)