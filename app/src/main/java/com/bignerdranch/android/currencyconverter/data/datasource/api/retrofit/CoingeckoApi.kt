package com.bignerdranch.android.currencyconverter.data.datasource.api.retrofit

import com.bignerdranch.android.currencyconverter.data.datasource.api.model.Rates
import com.bignerdranch.android.currencyconverter.data.datasource.api.model.RatesDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface CoingeckoApi {
    @GET("api/v3/exchange_rates")
    suspend fun loadRates(): Rates

    companion object Factory {
        fun create(): CoingeckoApi {
            val ratesDeserializer = GsonBuilder()
                    .registerTypeAdapter(Rates::class.java, RatesDeserializer()).create()

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(ratesDeserializer))
                    .baseUrl("https://api.coingecko.com/")
                    .build()

            return retrofit.create(CoingeckoApi::class.java)
        }
    }
}