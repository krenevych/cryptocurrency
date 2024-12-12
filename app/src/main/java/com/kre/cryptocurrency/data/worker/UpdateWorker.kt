package com.kre.cryptocurrency.data.worker

import android.content.Context
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kre.cryptocurrency.data.local.db.Dao
import com.kre.cryptocurrency.data.local.model.coinsToEntities
import com.kre.cryptocurrency.data.remote.model.CoinExchangeInfo
import com.kre.cryptocurrency.data.remote.model.CoinInfoRetrofit
import com.kre.cryptocurrency.data.remote.retrofit.BASE_CURRENCY
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import com.kre.cryptocurrency.domain.coin.CoinInfo
import kotlinx.coroutines.delay

class UpdateWorker(
    appContext: Context,
    params: WorkerParameters,
    private val serviceCryptoCurrency: ServiceCryptoCurrency,
    private val dao: Dao
) : CoroutineWorker(appContext, params) {

    private val numberCurrency = inputData.getInt(KEY_CURRENCY_NUMBER, 10)

    override suspend fun doWork(): Result {
        do {
            retrieve(numberCurrency)

            setProgress(workDataOf(KEY_WORK_PROGRESS to true))

            delay(UPDATE_PERIOD)

        } while (!isStopped)

        return Result.success()
    }

    private suspend fun retrieve(numberCurrency: Int) {
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
                                            coinExchangeInfo.toCoinInfo(
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

        fun request(
            numberCurrency: Int = 50,
        ): OneTimeWorkRequest {

            val constraints = Constraints.Builder().apply {
                setRequiredNetworkType(NetworkType.CONNECTED)
            }.build()

            val inputData = workDataOf(
                KEY_CURRENCY_NUMBER to numberCurrency,
            )

            val workRequest = OneTimeWorkRequestBuilder<UpdateWorker>()
                .setConstraints(constraints)
                .setInputData(inputData)
                .build()

            return workRequest
        }

        const val TAG = "XXXX"

        const val UPDATE_PERIOD = 10_000L

        const val KEY_CURRENCY_NUMBER = "CURRENCY_NUMBER"
        const val KEY_WORK_PROGRESS = "KEY_WORK_PROGRESS"

        val WORKER_NAME = UpdateWorker::class.simpleName ?: "WorkerName"
    }

}