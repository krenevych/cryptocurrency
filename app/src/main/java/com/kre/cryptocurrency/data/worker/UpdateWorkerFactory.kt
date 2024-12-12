package com.kre.cryptocurrency.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.kre.cryptocurrency.data.local.db.Dao
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import javax.inject.Inject

class UpdateWorkerFactory @Inject constructor(
    private val serviceCryptoCurrency: ServiceCryptoCurrency,
    private val dao: Dao,
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        return when (workerClassName) {

            UpdateWorker::class.java.name ->
                UpdateWorker(appContext, workerParameters, serviceCryptoCurrency, dao)

            else -> null
        }
    }

}
