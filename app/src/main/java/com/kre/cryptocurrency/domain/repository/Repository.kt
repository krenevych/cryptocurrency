package com.kre.cryptocurrency.domain.repository

import androidx.lifecycle.LiveData

interface Repository {
    fun getLiveData() : LiveData<String>
    fun retrieve()
}
