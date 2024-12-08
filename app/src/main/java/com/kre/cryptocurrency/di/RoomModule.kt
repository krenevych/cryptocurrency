package com.kre.cryptocurrency.di

import android.app.Application
import com.kre.cryptocurrency.data.local.db.CoinDatabase
import com.kre.cryptocurrency.data.local.db.Dao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun getDao(context: Application): Dao {
        return CoinDatabase.getDatabase(context).dao()
    }
}