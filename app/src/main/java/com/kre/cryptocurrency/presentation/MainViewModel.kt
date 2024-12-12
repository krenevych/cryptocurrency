package com.kre.cryptocurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.usecase.CancelWorkerJob
import com.kre.cryptocurrency.domain.usecase.GetItemsUseCase
import com.kre.cryptocurrency.domain.usecase.StartWorkerUpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val startWorkerUpdateUseCase: StartWorkerUpdateUseCase,
    private val cancelWorkerJob: CancelWorkerJob,
) : ViewModel(){

    val remoteLiveData: LiveData<List<CoinInfo>>
        get() = getItemsUseCase()


    init {
        startWorkerUpdateUseCase(50)
    }

    override fun onCleared() {
        super.onCleared()

        cancelWorkerJob()
    }

}