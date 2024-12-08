package com.kre.cryptocurrency.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kre.cryptocurrency.data.local.model.CoinInfoEntity

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [CoinInfoEntity::class], version = 1)
abstract class CoinDatabase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CoinDatabase? = null

        fun getDatabase(context: Context): CoinDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let { return it }  // if (INSTANCE != null) return@synchronized INSTANCE!!
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoinDatabase::class.java,
                    "CoinDatabase"
                )
                    .allowMainThreadQueries()  // allows request from DB in main thread
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}