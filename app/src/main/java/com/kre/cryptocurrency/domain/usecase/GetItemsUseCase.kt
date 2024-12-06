package com.kre.cryptocurrency.domain.usecase

import androidx.lifecycle.LiveData
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: Repository
)

{
    operator fun invoke(): LiveData<List<CoinBaseInfo>> {
        val liveData: LiveData<List<CoinBaseInfo>> = repository.getLiveData()
        return liveData
    }
}