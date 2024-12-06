package com.kre.cryptocurrency.domain.usecase

import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RetrieveDataUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() {
        repository.retrieve()
    }

}
