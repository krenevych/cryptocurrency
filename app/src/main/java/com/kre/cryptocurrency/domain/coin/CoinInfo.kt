package com.kre.cryptocurrency.domain.coin


import com.google.gson.annotations.SerializedName

data class CoinInfo(
    @SerializedName("Algorithm")
    val algorithm: String?,
    @SerializedName("AssetLaunchDate")
    val assetLaunchDate: String?,
    @SerializedName("BlockNumber")
    val blockNumber: Int?,
    @SerializedName("BlockReward")
    val blockReward: Double?,
    @SerializedName("BlockTime")
    val blockTime: Int?,
    @SerializedName("DocumentType")
    val documentType: String?,
    @SerializedName("FullName")
    val fullName: String?,
    @SerializedName("Id")
    val id: String?,
    @SerializedName("ImageUrl")
    val imageUrl: String?,
    @SerializedName("Internal")
    val `internal`: String?,
    @SerializedName("MaxSupply")
    val maxSupply: Double?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("NetHashesPerSecond")
    val netHashesPerSecond: Long?,
    @SerializedName("ProofType")
    val proofType: String?,
    @SerializedName("Rating")
    val type: Int?,
    @SerializedName("Url")
    val url: String?
)