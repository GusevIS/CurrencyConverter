package com.bignerdranch.android.currencyconverter.data.repository

import android.content.Context
import com.bignerdranch.android.currencyconverter.data.datasource.api.model.RateDtoMapper
import com.bignerdranch.android.currencyconverter.data.datasource.api.retrofit.CoingeckoApi
import com.bignerdranch.android.currencyconverter.data.datasource.cache.RateDB
import com.bignerdranch.android.currencyconverter.data.datasource.cache.RateDao
import com.bignerdranch.android.currencyconverter.data.datasource.cache.model.RateDBMapper
import com.bignerdranch.android.currencyconverter.domain.model.Rate
import kotlinx.coroutines.*
import java.lang.Exception

class RatesRepositoryImpl(context: Context) : RatesRepository {
    private val retrofitService: CoingeckoApi = CoingeckoApi.create()
    private val retrofitMapper: RateDtoMapper = RateDtoMapper()
    private val databaseMapper: RateDBMapper = RateDBMapper()
    private val cacheDao: RateDao = RateDB.getInstance(context).rateDao()

    override suspend fun getRatesFromCache(): LinkedHashMap<String, Rate> {
        var rates = LinkedHashMap<String, Rate> ()
        withContext(Dispatchers.IO) {
            try {
                rates = databaseMapper.toDomainMap(cacheDao.getAllRates())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return rates
    }

    override suspend fun getRates(): LinkedHashMap<String, Rate> {
        var rates = LinkedHashMap<String, Rate>()
        withContext(Dispatchers.IO) {
            try {
                rates = retrofitMapper.toDomainMap(retrofitService.loadRates())
                launch {
                    cacheDao.refreshRates(databaseMapper.fromDomainModel(rates))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return rates
    }
}