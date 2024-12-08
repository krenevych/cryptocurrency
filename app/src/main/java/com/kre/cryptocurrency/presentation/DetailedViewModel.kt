package com.kre.cryptocurrency.presentation

import androidx.lifecycle.ViewModel
import com.kre.cryptocurrency.domain.usecase.GetCoinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailedViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase
): ViewModel() {

    fun getCoinInfo(id: Int) = getCoinInfoUseCase(id)

}
