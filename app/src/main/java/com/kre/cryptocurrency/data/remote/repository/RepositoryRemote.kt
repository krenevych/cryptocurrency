package com.kre.cryptocurrency.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RepositoryRemote @Inject constructor() : Repository {

    private val _liveData = MutableLiveData<String>("Hello! 123")

    override fun getLiveData(): LiveData<String> {
        return _liveData
    }

    override fun retrieve() {
//        TODO("Not yet implemented")
        _liveData.value = "New value"
    }
}
