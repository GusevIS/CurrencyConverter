package com.bignerdranch.android.currencyconverter.models

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import java.math.BigDecimal

data class Rates (
    @SerializedName("rates") var rates : LinkedHashMap<String, Rate>
)

data class Rate (
    @SerializedName("unit") var unit : String?,
    @SerializedName("value") var value : BigDecimal?,
    @SerializedName("type") var type : String?,
    @SerializedName("calculatedValue") var calculatedValue : BigDecimal?
)

class RatesDeserializer(): JsonDeserializer<Rates> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Rates {

        val rates = LinkedHashMap<String, Rate> ()

        val jsonObject = json?.asJsonObject

        val jsonRatesList = jsonObject?.get("rates")?.asJsonObject

        var jsonBtc = jsonRatesList?.get("btc")?.asJsonObject
        var value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("eth")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ltc")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bch")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bnb")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("eos")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("xrp")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("xlm")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("link")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("dot")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("yfi")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("usd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("aed")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ars")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("aud")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bdt")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bhd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bmd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("brl")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("cad")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("chf")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("clp")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("cny")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("czk")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("dkk")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("eur")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("gbp")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("hkd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("huf")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("idr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ils")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("inr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("jpy")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("krw")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("kwd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("lkr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("mmk")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("mxn")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("myr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ngn")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("nok")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("huf")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("idr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ils")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("inr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("jpy")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("krw")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("kwd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("lkr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("mmk")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("mxn")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("myr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("ngn")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("nok")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("nzd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("php")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("pkr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("pln")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("rub")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("sar")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("sek")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("sgd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("thb")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("try")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("twd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("uah")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("vef")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("vnd")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("zar")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("xdr")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("xag")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("xau")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("bits")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))
        jsonBtc = jsonRatesList?.get("sats")?.asJsonObject
        value = jsonBtc?.get("value")?.asBigDecimal
        rates.put(jsonBtc?.get("name")!!.asString, Rate(jsonBtc?.get("unit")?.asString,
                value, jsonBtc?.get("type")?.asString, value))

        return Rates(rates)
    }
}