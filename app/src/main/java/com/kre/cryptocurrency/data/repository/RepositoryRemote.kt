package com.kre.cryptocurrency.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.kre.cryptocurrency.data.local.db.Dao
import com.kre.cryptocurrency.data.local.model.entitiesToItems
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import com.kre.cryptocurrency.data.worker.UpdateWorker
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.kre.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RepositoryRemote @Inject constructor(
    private val serviceCryptoCurrency: ServiceCryptoCurrency,
    private val dao: Dao,
    application: Application,
) : Repository {

    private val workManager: WorkManager = WorkManager.getInstance(application)

    override fun getLiveData(): LiveData<List<CoinInfo>> {
        val entityLiveData = dao.itemsLiveData()
        return MediatorLiveData<List<CoinInfo>>().apply {
            addSource(entityLiveData) {
                value = entitiesToItems(it)
            }
        }
    }

    override fun getCoinInfo(id: Int): LiveData<CoinInfo> {
        val infoEntityLiveData = dao.getItem(id)
        return MediatorLiveData<CoinInfo>().apply {
            addSource(infoEntityLiveData) {
                value = it.toCoinInfo()
            }
        }
    }

    override fun startUpdater(numberCurrency: Int) {
        workManager.enqueueUniqueWork(
            UpdateWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            UpdateWorker.request(
                numberCurrency = numberCurrency
            )
        )
    }

    override fun stopUpdate() {
        workManager.cancelAllWork()

        Log.d(TAG, "stopUpdate: cancel all work")
    }


    companion object {
        val TAG = "XXXX"
    }
}
