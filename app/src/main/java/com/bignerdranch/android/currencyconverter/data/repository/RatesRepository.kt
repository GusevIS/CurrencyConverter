package com.bignerdranch.android.currencyconverter.data.repository

import com.bignerdranch.android.currencyconverter.domain.model.Rate

interface RatesRepository {
    suspend fun getRates(): LinkedHashMap<String, Rate>
    suspend fun getRatesFromCache(): LinkedHashMap<String, Rate>
}