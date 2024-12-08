package com.kre.cryptocurrency.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kre.cryptocurrency.domain.coin.CoinInfo

@Entity(tableName = "CoinInfoTable")
data class CoinEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "fullName")
    val fullName: String?,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?,

    @ColumnInfo(name = "lastUpdate")
    val lastUpdate: String? = null,

    @ColumnInfo(name = "toCurrency")
    val toCurrency: String? = null,

    @ColumnInfo(name = "price")
    val price: Double? = null,

    @ColumnInfo(name = "dayMinimum")
    val dayMinimum: Double? = null,

    @ColumnInfo(name = "dayMaximum")
    val dayMaximum: Double? = null,

    @ColumnInfo(name = "lastDeal")
    val lastDeal: String? = null,

    @ColumnInfo(name = "low24hour")
    val low24hour: Double? = null,

    @ColumnInfo(name = "high24hour")
    val high24hour: Double? = null,

    @ColumnInfo(name = "lowHour")
    val lowHour: Double? = null,

    @ColumnInfo(name = "highHour")
    val highHour: Double? = null,

) {

    fun toCoinInfo() = CoinInfo(
        fullName = fullName,
        id = id,
        imageUrl = imageUrl,
        name = name,
        lastUpdate = lastUpdate,
        toCurrency = toCurrency,
        price = price,
        dayMinimum = dayMinimum,
        dayMaximum = dayMaximum,
        lastDeal = lastDeal,

        low24hour = this.low24hour,
        high24hour = this.high24hour,
        lowHour = this.lowHour,
        highHour = this.highHour,

        )

    companion object {
        fun CoinInfo.toEntity() = CoinEntity(
            fullName = fullName,
            id = id,
            imageUrl = imageUrl,
            name = name,
            lastUpdate = lastUpdate,
            toCurrency = toCurrency,
            price = price,
            dayMinimum = dayMinimum,
            dayMaximum = dayMaximum,
            lastDeal = lastDeal,

            low24hour = this.low24hour,
            high24hour = this.high24hour,
            lowHour = this.lowHour,
            highHour = this.highHour,
        )
    }
}