package com.kre.cryptocurrency.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kre.cryptocurrency.data.local.model.CoinInfoEntity

@Dao
interface Dao {

    @Query("SELECT * FROM CoinInfoTable ORDER BY id ASC")
    fun itemsLiveData(): LiveData<List<CoinInfoEntity>>  // when function returns LiveData it has suspend-functionality under the hood.

    @Query("SELECT * FROM CoinInfoTable WHERE id LIKE :id LIMIT 1")
    suspend fun getItem(id: Int): CoinInfoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: CoinInfoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItems(coins: List<CoinInfoEntity>)

    @Delete
    suspend fun removeItem(item: CoinInfoEntity)

    @Update
    suspend fun changeItem(item: CoinInfoEntity)

    @Update
    suspend fun update(coins: List<CoinInfoEntity>)

}