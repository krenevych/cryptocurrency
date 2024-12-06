package com.kre.cryptocurrency.domain.usecase

import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RetrieveDataUseCase @Inject constructor(
    private val repository: Repository,
) {

    suspend operator fun invoke(numberCurrency: Int) {
        repository.retrieve(numberCurrency)
    }

}
