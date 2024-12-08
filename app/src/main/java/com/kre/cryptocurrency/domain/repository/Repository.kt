package com.kre.cryptocurrency.domain.repository

import androidx.lifecycle.LiveData
import com.kre.cryptocurrency.domain.coin.CoinInfo

interface Repository {
    fun getLiveData() : LiveData<List<CoinInfo>>
    suspend fun getCoinInfo(id: Int) : CoinInfo
    suspend fun retrieve(numberCurrency: Int)
}
