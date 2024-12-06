package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo

data class CoinInfo(
//    @SerializedName("Algorithm")
//    val algorithm: String? = null,
//    @SerializedName("AssetLaunchDate")
//    val assetLaunchDate: String? = null,
//    @SerializedName("BlockNumber")
//    val blockNumber: Int? = null,
//    @SerializedName("BlockReward")
//    val blockReward: Double? = null,
//    @SerializedName("BlockTime")
//    val blockTime: Double? = null,
//    @SerializedName("DocumentType")
//    val documentType: String? = null,
    @SerializedName("FullName")
    val fullName: String? = null,
    @SerializedName("Id")
    val id: String? = null,
    @SerializedName("ImageUrl")
    val imageUrl: String? = null,
//    @SerializedName("Internal")
//    val `internal`: String? = null,
//    @SerializedName("MaxSupply")
//    val maxSupply: Double? = null,
    @SerializedName("Name")
    val name: String? = null,
//    @SerializedName("NetHashesPerSecond")
//    val netHashesPerSecond: Double? = null,
//    @SerializedName("ProofType")
//    val proofType: String? = null,
//    @SerializedName("Rating")
//    val rating: Rating? = null,
//    @SerializedName("Type")
//    val type: Int? = null,
    @SerializedName("Url")
    val url: String? = null,
) {

    fun toCoinBase(): CoinBaseInfo {
        return CoinBaseInfo(
            id = this.id,
            name = this.name,
            fullName = this.fullName,
            imageUrl = this.imageUrl,
        )
    }


}