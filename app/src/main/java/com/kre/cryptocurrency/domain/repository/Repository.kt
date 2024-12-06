package com.kre.cryptocurrency.domain.repository

import androidx.lifecycle.LiveData
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo

interface Repository {
    fun getLiveData() : LiveData<List<CoinBaseInfo>>
    fun retrieve()
}
