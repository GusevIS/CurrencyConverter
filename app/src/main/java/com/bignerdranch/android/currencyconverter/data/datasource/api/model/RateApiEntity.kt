package com.bignerdranch.android.currencyconverter.data.datasource.api.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import java.math.BigDecimal
import kotlin.collections.LinkedHashMap

data class Rates(var rates: LinkedHashMap<String, RateApiEntity>)

data class RateApiEntity(
    @SerializedName("unit") var unit: String?,
    @SerializedName("value") var value: BigDecimal?,
    @SerializedName("type") var type: String?
)

class RatesDeserializer() : JsonDeserializer<Rates> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Rates {
        val rates = LinkedHashMap<String, RateApiEntity> ()
        val jsonObject = json?.asJsonObject
        val jsonRatesList = jsonObject?.get("rates")?.asJsonObject

        val keys = jsonRatesList?.entrySet()?.map { it.key }

        keys?.forEach { key ->
            val rateObj = jsonRatesList.get(key)?.asJsonObject!!
            rates[rateObj.get("name").asString!!] = RateApiEntity(rateObj.get("unit")?.asString,
                    rateObj.get("value")?.asBigDecimal, rateObj.get("type")?.asString)
        }

        return Rates(rates)
    }
}