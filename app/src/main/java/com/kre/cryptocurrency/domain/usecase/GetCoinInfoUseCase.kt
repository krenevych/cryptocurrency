package com.kre.cryptocurrency.domain.usecase

import androidx.lifecycle.LiveData
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: Int) : LiveData<CoinInfo> {
        return repository.getCoinInfo(id)
    }
}