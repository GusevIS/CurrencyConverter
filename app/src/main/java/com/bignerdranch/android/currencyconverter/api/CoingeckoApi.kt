package com.bignerdranch.android.currencyconverter.api

import com.bignerdranch.android.currencyconverter.models.Rates
import com.bignerdranch.android.currencyconverter.models.RatesDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.http.GET
import io.reactivex.rxjava3.core.*
import hu.akarnokd.rxjava3.retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

interface CoingeckoApi {
    @GET("api/v3/exchange_rates")
    fun loadRates(): Observable<Rates>

    companion object Factory{
        fun create(): CoingeckoApi {
            val ratesDeserializer = GsonBuilder()
                    .registerTypeAdapter(Rates::class.java, RatesDeserializer()).create()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(ratesDeserializer))
                    .baseUrl("https://api.coingecko.com/")
                    .build()

            return retrofit.create(CoingeckoApi::class.java)
        }
    }
}