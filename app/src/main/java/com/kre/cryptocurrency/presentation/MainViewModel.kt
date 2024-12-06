package com.kre.cryptocurrency.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.usecase.GetItemsUseCase
import com.kre.cryptocurrency.domain.usecase.RetrieveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val retrieveDataUseCase: RetrieveDataUseCase
) : ViewModel(){

    val remoteLiveData: LiveData<List<CoinInfo>>
        get() = getItemsUseCase()


    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(TAG, "CoroutineExceptionHandler got $exception")
    }

    fun retrieve(numberCurrency: Int) {
        viewModelScope.launch(handler) {
            retrieveDataUseCase(numberCurrency)
        }

    }
}