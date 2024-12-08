package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kre.cryptocurrency.data.remote.retrofit.BASE_URL
import com.kre.cryptocurrency.domain.coin.CoinInfo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


data class CoinExchangeInfo(
    @SerializedName("CHANGE24HOUR")
    val change24hour: Double? = null,
    @SerializedName("CHANGEDAY")
    val changeDay: Double? = null,
    @SerializedName("CHANGEHOUR")
    val changeHour: Double? = null,
    @SerializedName("CHANGEPCT24HOUR")
    val changePCT24hour: Double? = null,
    @SerializedName("CHANGEPCTDAY")
    val changepctDay: Double? = null,
    @SerializedName("CHANGEPCTHOUR")
    val changepctHour: Double? = null,
    @SerializedName("CIRCULATINGSUPPLY")
    val circulatingsupply: Int? = null,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val circulatingsupplymktcap: Double? = null,
    @SerializedName("CONVERSIONLASTUPDATE")
    val conversionlastupdate: Int? = null,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionsymbol: String? = null,
    @SerializedName("CONVERSIONTYPE")
    val conversiontype: String? = null,
    @SerializedName("FLAGS")
    val flags: String? = null,
    @SerializedName("FROMSYMBOL")
    val fromsymbol: String? = null,
    @SerializedName("HIGH24HOUR")
    val high24hour: Double? = null,
    @SerializedName("HIGHDAY")
    val highDay: Double? = null,
    @SerializedName("HIGHHOUR")
    val highHour: Double? = null,
    @SerializedName("IMAGEURL")
    val imageUrl: String? = null,
    @SerializedName("LASTMARKET")
    val lastMarket: String? = null,
    @SerializedName("LASTTRADEID")
    val lastTradeId: String? = null,
    @SerializedName("LASTUPDATE")
    val lastUpdate: Long? = null,
    @SerializedName("LASTVOLUME")
    val lastVolume: Double? = null,
    @SerializedName("LASTVOLUMETO")
    val lastVolumeTo: Double? = null,
    @SerializedName("LOW24HOUR")
    val low24hour: Double? = null,
    @SerializedName("LOWDAY")
    val lowDay: Double? = null,
    @SerializedName("LOWHOUR")
    val lowHour: Double? = null,
    @SerializedName("MARKET")
    val market: String? = null,
    @SerializedName("MEDIAN")
    val median: Double? = null,
    @SerializedName("MKTCAP")
    val mktcap: Double? = null,
    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Int? = null,
    @SerializedName("OPEN24HOUR")
    val open24hour: Double? = null,
    @SerializedName("OPENDAY")
    val openDay: Double? = null,
    @SerializedName("OPENHOUR")
    val openHour: Double? = null,
    @SerializedName("PRICE")
    val price: Double? = null,
    @SerializedName("SUPPLY")
    val supply: Int? = null,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24hour: Double? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24hourto: Double? = null,
    @SerializedName("TOSYMBOL")
    val toSymbol: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totalToptierVolume24h: Double? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totalTopTierVolume24hto: Double? = null,
    @SerializedName("TOTALVOLUME24H")
    val totalVolume24h: Double? = null,
    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24hto: Double? = null,
    @SerializedName("TYPE")
    val type: String? = null,
    @SerializedName("VOLUME24HOUR")
    val volume24hour: Double? = null,
    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: Double? = null,
    @SerializedName("VOLUMEDAY")
    val volumeDay: Double? = null,
    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: Double? = null,
    @SerializedName("VOLUMEHOUR")
    val volumeHour: Double? = null,
    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: Double? = null,
) {

    private val simpleDateFormat by lazy { SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()) }

    private fun getDate(timeStamp: Long): String = simpleDateFormat.format(Date(timeStamp * 1000))

    fun toCoinBase(id: Int, fullName: String): CoinInfo {

        val date = this.lastUpdate?.let { getDate(it) } ?: Date()

        return CoinInfo(
            id = id,
            name = this.fromsymbol,
            fullName = fullName,
            imageUrl = "$BASE_URL${this.imageUrl}",
            toCurrency = this.toSymbol,
            price = this.price,
            lastUpdate = date.toString()
        )
    }

}