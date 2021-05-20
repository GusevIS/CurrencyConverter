package com.bignerdranch.android.currencyconverter.data.datasource.cache

import androidx.room.*
import com.bignerdranch.android.currencyconverter.data.datasource.cache.model.RateDBEntity

@Dao
interface RateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRates(rates: List<RateDBEntity>)

    @Query("SELECT * FROM rate")
    suspend fun getAllRates(): List<RateDBEntity>

    @Query("DELETE FROM rate")
    suspend fun removeAllRates()

    @Transaction
    suspend fun refreshRates(rates: List<RateDBEntity>) {
        removeAllRates()
        addRates(rates)
    }
}