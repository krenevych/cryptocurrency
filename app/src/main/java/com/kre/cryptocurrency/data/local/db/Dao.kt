package com.kre.cryptocurrency.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kre.cryptocurrency.data.local.model.CoinEntity

@Dao
interface Dao {

    @Query("SELECT * FROM CoinInfoTable ORDER BY id ASC")
    fun itemsLiveData(): LiveData<List<CoinEntity>>  // when function returns LiveData it has suspend-functionality under the hood.

    @Query("SELECT * FROM CoinInfoTable WHERE id LIKE :id LIMIT 1")
    fun getItem(id: Int): LiveData<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: CoinEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItems(coins: List<CoinEntity>)

    @Delete
    suspend fun removeItem(item: CoinEntity)

    @Update
    suspend fun changeItem(item: CoinEntity)

    @Update
    suspend fun update(coins: List<CoinEntity>)

}