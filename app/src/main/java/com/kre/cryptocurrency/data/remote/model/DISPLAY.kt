package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class DISPLAY(
    @SerializedName("USD")
    val uSD: USD? = null
)