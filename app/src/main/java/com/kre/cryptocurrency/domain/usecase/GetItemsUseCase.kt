package com.kre.cryptocurrency.domain.usecase

import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke() = repository.getLiveData()

}