package com.kre.cryptocurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo
import com.kre.cryptocurrency.domain.usecase.GetItemsUseCase
import com.kre.cryptocurrency.domain.usecase.RetrieveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val retrieveDataUseCase: RetrieveDataUseCase
) : ViewModel(){

    val remoteLiveData: LiveData<List<CoinBaseInfo>>
        get() = getItemsUseCase()


    fun retrieve() {
        retrieveDataUseCase()
    }
}