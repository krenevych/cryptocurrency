package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Weiss")
    val weiss: Weiss? = null
)