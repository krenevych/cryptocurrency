package com.kre.cryptocurrency.data.remote.model


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("CHANGE24HOUR")
    val cHANGE24HOUR: String? = null,
    @SerializedName("CHANGEDAY")
    val cHANGEDAY: String? = null,
    @SerializedName("CHANGEHOUR")
    val cHANGEHOUR: String? = null,
    @SerializedName("CHANGEPCT24HOUR")
    val cHANGEPCT24HOUR: String? = null,
    @SerializedName("CHANGEPCTDAY")
    val cHANGEPCTDAY: String? = null,
    @SerializedName("CHANGEPCTHOUR")
    val cHANGEPCTHOUR: String? = null,
    @SerializedName("CIRCULATINGSUPPLY")
    val cIRCULATINGSUPPLY: String? = null,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val cIRCULATINGSUPPLYMKTCAP: String? = null,
    @SerializedName("CONVERSIONLASTUPDATE")
    val cONVERSIONLASTUPDATE: String? = null,
    @SerializedName("CONVERSIONSYMBOL")
    val cONVERSIONSYMBOL: String? = null,
    @SerializedName("CONVERSIONTYPE")
    val cONVERSIONTYPE: String? = null,
    @SerializedName("FROMSYMBOL")
    val fROMSYMBOL: String? = null,
    @SerializedName("HIGH24HOUR")
    val hIGH24HOUR: String? = null,
    @SerializedName("HIGHDAY")
    val hIGHDAY: String? = null,
    @SerializedName("HIGHHOUR")
    val hIGHHOUR: String? = null,
    @SerializedName("IMAGEURL")
    val iMAGEURL: String? = null,
    @SerializedName("LASTMARKET")
    val lASTMARKET: String? = null,
    @SerializedName("LASTTRADEID")
    val lASTTRADEID: String? = null,
    @SerializedName("LASTUPDATE")
    val lASTUPDATE: String? = null,
    @SerializedName("LASTVOLUME")
    val lASTVOLUME: String? = null,
    @SerializedName("LASTVOLUMETO")
    val lASTVOLUMETO: String? = null,
    @SerializedName("LOW24HOUR")
    val lOW24HOUR: String? = null,
    @SerializedName("LOWDAY")
    val lOWDAY: String? = null,
    @SerializedName("LOWHOUR")
    val lOWHOUR: String? = null,
    @SerializedName("MARKET")
    val mARKET: String? = null,
    @SerializedName("MKTCAP")
    val mKTCAP: String? = null,
    @SerializedName("MKTCAPPENALTY")
    val mKTCAPPENALTY: String? = null,
    @SerializedName("OPEN24HOUR")
    val oPEN24HOUR: String? = null,
    @SerializedName("OPENDAY")
    val oPENDAY: String? = null,
    @SerializedName("OPENHOUR")
    val oPENHOUR: String? = null,
    @SerializedName("PRICE")
    val pRICE: String? = null,
    @SerializedName("SUPPLY")
    val sUPPLY: String? = null,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val tOPTIERVOLUME24HOUR: String? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val tOPTIERVOLUME24HOURTO: String? = null,
    @SerializedName("TOSYMBOL")
    val tOSYMBOL: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val tOTALTOPTIERVOLUME24H: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val tOTALTOPTIERVOLUME24HTO: String? = null,
    @SerializedName("TOTALVOLUME24H")
    val tOTALVOLUME24H: String? = null,
    @SerializedName("TOTALVOLUME24HTO")
    val tOTALVOLUME24HTO: String? = null,
    @SerializedName("VOLUME24HOUR")
    val vOLUME24HOUR: String? = null,
    @SerializedName("VOLUME24HOURTO")
    val vOLUME24HOURTO: String? = null,
    @SerializedName("VOLUMEDAY")
    val vOLUMEDAY: String? = null,
    @SerializedName("VOLUMEDAYTO")
    val vOLUMEDAYTO: String? = null,
    @SerializedName("VOLUMEHOUR")
    val vOLUMEHOUR: String? = null,
    @SerializedName("VOLUMEHOURTO")
    val vOLUMEHOURTO: String? = null
)