package com.kre.cryptocurrency.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kre.cryptocurrency.data.local.db.Dao
import com.kre.cryptocurrency.data.local.model.coinsToEntities
import com.kre.cryptocurrency.data.local.model.entitiesToItems
import com.kre.cryptocurrency.data.remote.model.CoinExchangeInfo
import com.kre.cryptocurrency.data.remote.model.CoinInfoRetrofit
import com.kre.cryptocurrency.data.remote.retrofit.BASE_CURRENCY
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RepositoryRemote @Inject constructor(
    private val serviceCryptoCurrency: ServiceCryptoCurrency,
    private val dao: Dao
) : Repository {

    override fun getLiveData(): LiveData<List<CoinInfo>> {
        val entityLiveData = dao.itemsLiveData()
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(entityLiveData) {
                value = entitiesToItems(it)
            }
        }
    }

    override fun getCoinInfo(id: Int): LiveData<CoinInfo> {

        val infoEntityLiveData = dao.getItem(id)

        return MediatorLiveData<CoinInfo>().apply {
            addSource(infoEntityLiveData) {
                value = it.toCoinInfo()
            }
        }

//        return dao.getItem(id).toCoinInfo()
    }

    override suspend fun retrieve(numberCurrency: Int) {
        val responseCall = serviceCryptoCurrency.getCurrencyList(limit = numberCurrency)

        val cryptoCoinsMap = mutableMapOf<String, CoinInfoRetrofit>()
        val cryptoCoinsNames = responseCall?.let { response ->
            val coins = mutableListOf<String>()
            response.coins?.forEach { data ->
                data.coinInfo?.name?.let {
                    cryptoCoinsMap[it] = data.coinInfo
                    coins.add(it)
                }
            }

            coins
        }

        val queryCryptoCoinsNames = cryptoCoinsNames?.joinToString(",")
        queryCryptoCoinsNames?.let {
            serviceCryptoCurrency.getCurrencyExchange(fromCurrency = queryCryptoCoinsNames)
                ?.also { coinRawData ->
                    val listCurrency = mutableListOf<CoinInfo>()
                    for (coinName in cryptoCoinsNames) {
                        coinRawData.jsonObject?.let { jsonObject ->
                            if (jsonObject.has(coinName)) {

                                val jsonElementUsd = jsonObject.getAsJsonObject(coinName)

                                val crypto: JsonObject =
                                    jsonElementUsd.getAsJsonObject(BASE_CURRENCY)
                                val coinExchangeInfo =
                                    Gson().fromJson(crypto, CoinExchangeInfo::class.java)

                                cryptoCoinsMap[coinName]?.let {

                                    it.id?.let { id ->
                                        listCurrency.add(
                                            coinExchangeInfo.toCoinBase(
                                                id = id,
                                                fullName = it.fullName ?: it.name ?: ""
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }

                    val entities = coinsToEntities(listCurrency)
                    dao.addItems(entities)

                }
        }

    }


    companion object {
        val TAG = "XXXX"
    }
}
