package com.kre.cryptocurrency.presentation

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.kre.cryptocurrency.data.worker.UpdateWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CryptoCurrencyApplication : Application() {

    @Inject
    lateinit var myCustomWorkerFactory: UpdateWorkerFactory

    override fun onCreate() {
        super.onCreate()

        val configuration = Configuration.Builder()
            .setWorkerFactory(myCustomWorkerFactory)
            .build()

        WorkManager.initialize(this, configuration)
    }
}
