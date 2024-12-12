package com.kre.cryptocurrency.domain.usecase

import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class StartWorkerUpdateUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke(numberCurrency: Int) {
        repository.startUpdater(numberCurrency)
    }
}