package com.kre.cryptocurrency.domain.usecase

import androidx.lifecycle.LiveData
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: Repository
)

{
    operator fun invoke(): LiveData<String> {
        val liveData: LiveData<String> = repository.getLiveData()
        return liveData
    }
}