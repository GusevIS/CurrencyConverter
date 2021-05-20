package com.bignerdranch.android.currencyconverter.data.datasource.cache

import android.content.Context
import androidx.room.*
import com.bignerdranch.android.currencyconverter.data.datasource.cache.model.RateDBEntity

private const val DATABASE = "rates_database"

@Database(entities = [RateDBEntity::class], version = 1)
@TypeConverters(RateDBConverter::class)
abstract class RateDB: RoomDatabase() {
    abstract fun rateDao(): RateDao

    companion object{
        @Volatile
        private var instance: RateDB? = null

        fun getInstance(context: Context): RateDB {
            return instance ?: synchronized(this) {
                instance
                        ?: buildDataBase(context).also { instance = it}
            }
        }

        private fun buildDataBase(context: Context): RateDB {
            return  Room.databaseBuilder(context, RateDB::class.java, DATABASE).build()
        }
    }
}