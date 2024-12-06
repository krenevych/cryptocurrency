package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class USDX(
    @SerializedName("CHANGE24HOUR")
    val cHANGE24HOUR: Double? = null,
    @SerializedName("CHANGEDAY")
    val cHANGEDAY: Double? = null,
    @SerializedName("CHANGEHOUR")
    val cHANGEHOUR: Double? = null,
    @SerializedName("CHANGEPCT24HOUR")
    val cHANGEPCT24HOUR: Double? = null,
    @SerializedName("CHANGEPCTDAY")
    val cHANGEPCTDAY: Double? = null,
    @SerializedName("CHANGEPCTHOUR")
    val cHANGEPCTHOUR: Double? = null,
    @SerializedName("CIRCULATINGSUPPLY")
    val cIRCULATINGSUPPLY: Double? = null,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val cIRCULATINGSUPPLYMKTCAP: Double? = null,
    @SerializedName("CONVERSIONLASTUPDATE")
    val cONVERSIONLASTUPDATE: Int? = null,
    @SerializedName("CONVERSIONSYMBOL")
    val cONVERSIONSYMBOL: String? = null,
    @SerializedName("CONVERSIONTYPE")
    val cONVERSIONTYPE: String? = null,
    @SerializedName("FLAGS")
    val fLAGS: String? = null,
    @SerializedName("FROMSYMBOL")
    val fROMSYMBOL: String? = null,
    @SerializedName("HIGH24HOUR")
    val hIGH24HOUR: Double? = null,
    @SerializedName("HIGHDAY")
    val hIGHDAY: Double? = null,
    @SerializedName("HIGHHOUR")
    val hIGHHOUR: Double? = null,
    @SerializedName("IMAGEURL")
    val iMAGEURL: String? = null,
    @SerializedName("LASTMARKET")
    val lASTMARKET: String? = null,
    @SerializedName("LASTTRADEID")
    val lASTTRADEID: String? = null,
    @SerializedName("LASTUPDATE")
    val lASTUPDATE: Int? = null,
    @SerializedName("LASTVOLUME")
    val lASTVOLUME: Double? = null,
    @SerializedName("LASTVOLUMETO")
    val lASTVOLUMETO: Double? = null,
    @SerializedName("LOW24HOUR")
    val lOW24HOUR: Double? = null,
    @SerializedName("LOWDAY")
    val lOWDAY: Double? = null,
    @SerializedName("LOWHOUR")
    val lOWHOUR: Double? = null,
    @SerializedName("MARKET")
    val mARKET: String? = null,
    @SerializedName("MEDIAN")
    val mEDIAN: Double? = null,
    @SerializedName("MKTCAP")
    val mKTCAP: Double? = null,
    @SerializedName("MKTCAPPENALTY")
    val mKTCAPPENALTY: Int? = null,
    @SerializedName("OPEN24HOUR")
    val oPEN24HOUR: Double? = null,
    @SerializedName("OPENDAY")
    val oPENDAY: Double? = null,
    @SerializedName("OPENHOUR")
    val oPENHOUR: Double? = null,
    @SerializedName("PRICE")
    val pRICE: Double? = null,
    @SerializedName("SUPPLY")
    val sUPPLY: Double? = null,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val tOPTIERVOLUME24HOUR: Double? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val tOPTIERVOLUME24HOURTO: Double? = null,
    @SerializedName("TOSYMBOL")
    val tOSYMBOL: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val tOTALTOPTIERVOLUME24H: Double? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val tOTALTOPTIERVOLUME24HTO: Double? = null,
    @SerializedName("TOTALVOLUME24H")
    val tOTALVOLUME24H: Double? = null,
    @SerializedName("TOTALVOLUME24HTO")
    val tOTALVOLUME24HTO: Double? = null,
    @SerializedName("TYPE")
    val tYPE: String? = null,
    @SerializedName("VOLUME24HOUR")
    val vOLUME24HOUR: Double? = null,
    @SerializedName("VOLUME24HOURTO")
    val vOLUME24HOURTO: Double? = null,
    @SerializedName("VOLUMEDAY")
    val vOLUMEDAY: Double? = null,
    @SerializedName("VOLUMEDAYTO")
    val vOLUMEDAYTO: Double? = null,
    @SerializedName("VOLUMEHOUR")
    val vOLUMEHOUR: Double? = null,
    @SerializedName("VOLUMEHOURTO")
    val vOLUMEHOURTO: Double? = null
)