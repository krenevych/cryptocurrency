package com.kre.cryptocurrency.data.remote.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kre.cryptocurrency.data.remote.model.CoinExchangeInfo
import com.kre.cryptocurrency.data.remote.model.CoinInfoRetrofit
import com.kre.cryptocurrency.data.remote.retrofit.BASE_CURRENCY
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RepositoryRemote @Inject constructor(
    private val serviceCryptoCurrency: ServiceCryptoCurrency,
) : Repository {

    private val _liveData = MutableLiveData<List<CoinInfo>>()

    override fun getLiveData(): LiveData<List<CoinInfo>> {
        return _liveData
    }

    override suspend fun retrieve(numberCurrency: Int) {
        val responseCall = serviceCryptoCurrency.getCurrencyList(limit = numberCurrency)

        val coinsMap = mutableMapOf<String, CoinInfoRetrofit>()
        val coinsList = responseCall?.let { response ->
            val coins = mutableListOf<String>()
            response.coins?.forEach { data ->
                data.coinInfo?.name?.let {
                    coinsMap[it] = data.coinInfo
                    coins.add(it)
                }
            }

            coins
        }

        val coinsNames = coinsList?.joinToString(",")


        Log.d(TAG, "retrieve: $coinsNames")

        coinsNames?.let {
            serviceCryptoCurrency.getCurrencyExchange(fromCurrency = coinsNames)
                ?.also { coinRawData ->
                    val listCurrency = mutableListOf<CoinInfo>()
                    for (coinName in coinsList) {
                        coinRawData.jsonObject?.let { jsonObject ->
                            if (jsonObject.has(coinName)) {

                                val jsonElementUsd = jsonObject.getAsJsonObject(coinName)

                                val crypto: JsonObject =
                                    jsonElementUsd.getAsJsonObject(BASE_CURRENCY)
                                val coinExchangeInfo =
                                    Gson().fromJson(crypto, CoinExchangeInfo::class.java)

                                coinsMap[coinName]?.let {
                                    listCurrency.add(
                                        coinExchangeInfo.toCoinBase(
                                            id = it.id!!,
                                            fullName = it.fullName!!
                                        )
                                    )
                                }

                            }
                        }

                    }

                    _liveData.value = listCurrency
                }
        }

    }


    companion object {
        val TAG = "XXXX"
    }
}
