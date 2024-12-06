package com.kre.cryptocurrency.domain.coin


data class CoinInfo(
    val fullName: String?,
    val id: String?,
    val imageUrl: String?,
    val name: String?,
    val lastUpdate: String? = null,
    val toCurrency: String? = null,
    val price: Double? = null,

)