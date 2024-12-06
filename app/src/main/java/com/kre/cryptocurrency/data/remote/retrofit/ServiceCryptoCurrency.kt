package com.kre.cryptocurrency.data.remote.retrofit

import com.kre.cryptocurrency.data.remote.model.CoinResponse
import com.kre.cryptocurrency.data.remote.model.CoinPrice
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ServiceCryptoCurrency {

//    https://min-api.cryptocompare.com/data/top/totalvolfull?limit=3&tsym=USD
    @GET("data/top/totalvolfull")
    suspend fun getCurrencyList(
        @Query(QUERY_PARAM_LIMIT)
        limit: Int = 10,

        @Query(QUERY_PARAM_TO_SYMBOL)
        toCurrency: String = BASE_CURRENCY,

        ): CoinResponse?

    @GET("data/pricemultifull")
    suspend fun getCurrencyExchange(

        @Query(QUERY_PARAM_FROM_SYMBOLS)
        fromCurrency: String = BASE_CRYPTO_CURRENCY,

        @Query(QUERY_PARAM_TO_SYMBOLS)
        toCurrency: String = BASE_CURRENCY,

        ): CoinResponse?

//    https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR
    @GET("data/price")
    suspend fun getCurrencyData(
    @Query(QUERY_PARAM_FROM_SYMBOLS)
    fromCurrency: String = BASE_CRYPTO_CURRENCY,

    @Query(QUERY_PARAM_TO_SYMBOLS)
    toCurrency: String?,

    ) : CoinPrice?
}