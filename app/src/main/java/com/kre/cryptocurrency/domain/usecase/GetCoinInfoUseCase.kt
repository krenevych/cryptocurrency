package com.kre.cryptocurrency.domain.usecase

import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.repository.Repository

class GetCoinInfoUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) : CoinInfo {
        return repository.getCoinInfo(id)
    }
}