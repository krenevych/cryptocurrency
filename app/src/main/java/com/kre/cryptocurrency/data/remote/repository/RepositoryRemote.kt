package com.kre.cryptocurrency.data.remote.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kre.cryptocurrency.data.remote.model.CoinInfo
import com.kre.cryptocurrency.data.remote.model.CoinResponse
import com.kre.cryptocurrency.data.remote.model.CoinPrice
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo
import com.kre.cryptocurrency.domain.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryRemote @Inject constructor(
    private val serviceCryptoCurrency: ServiceCryptoCurrency
) : Repository {

    private val _liveData = MutableLiveData<List<CoinBaseInfo>>()

    override fun getLiveData(): LiveData<List<CoinBaseInfo>> {
        return _liveData
    }

    override fun retrieve() {
        val responseCall = serviceCryptoCurrency.getCurrencyList(limit = 15)
        responseCall?.enqueue(object : Callback<CoinResponse> {
            override fun onResponse(coinResponseCall: Call<CoinResponse>, response: Response<CoinResponse>) {

                response.body()?.let {

                    it.coins ?: return

                    val coins = mutableListOf<CoinBaseInfo>()
                    it.coins.forEach { data ->
                        data.coinInfo?.let { coinInfo: CoinInfo ->
                            coins += coinInfo.toCoinBase()
                        }
                    }

                    _liveData.value = coins
                }


            }

            override fun onFailure(coinResponseCall: Call<CoinResponse>, throwable: Throwable) {
                Log.e(TAG, "onFailure: $throwable")

                _liveData.value = listOf()
            }

        })

    }

//    fun retrieveCryptoCurrency() {
//        val coinPriceCall = serviceCryptoCurrency.getCurrencyData("BTC", "USD,JPY,EUR")
//        coinPriceCall?.enqueue(object : Callback<CoinPrice> {
//            override fun onResponse(
//                coinResponseCall: Call<CoinPrice>,
//                response: Response<CoinPrice>,
//            ) {
//                _liveData.value = response.body().toString()
//            }
//
//            override fun onFailure(coinResponseCall: Call<CoinPrice>, throwable: Throwable) {
//                _liveData.value = throwable.message
//            }
//
//        })
//    }


    companion object {
        val TAG = "XXXX"
    }
}
