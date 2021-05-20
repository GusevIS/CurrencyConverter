package com.bignerdranch.android.currencyconverter.data.datasource.api.model

import com.bignerdranch.android.currencyconverter.domain.model.Rate

class RateDtoMapper {
    private fun toDomainModel(model: RateApiEntity): Rate {
        return Rate(
                unit = model.unit,
                value = model.value,
                type = model.type,
                calculatedValue = model.value
        )
    }

    fun toDomainMap(rates: Rates): LinkedHashMap<String, Rate> {
        val keys = rates.rates.keys
        val domainMap = LinkedHashMap<String, Rate> ()
        keys.forEach{ key ->
            domainMap[key] = toDomainModel(rates.rates[key]!!)
        }
        return domainMap
    }
}