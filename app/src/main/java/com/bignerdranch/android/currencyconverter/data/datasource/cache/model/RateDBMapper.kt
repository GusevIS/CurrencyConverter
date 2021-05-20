package com.bignerdranch.android.currencyconverter.data.datasource.cache.model

import com.bignerdranch.android.currencyconverter.domain.model.Rate

class RateDBMapper {
    private fun toDomainModel(model: RateDBEntity): Rate {
        return Rate(
            unit = model.unit,
            value = model.value,
            type = model.type,
            calculatedValue = model.value
        )
    }

    fun fromDomainModel(models: LinkedHashMap<String, Rate>): List<RateDBEntity> {
        val ratesEntities = ArrayList<RateDBEntity>()
        val keys = models.keys
        keys.forEach{ key ->
            ratesEntities.add(
                RateDBEntity(0, key, models[key]?.unit, models[key]?.value,
                models[key]?.type))
        }
        return ratesEntities
    }

    fun toDomainMap(rates: List<RateDBEntity>): LinkedHashMap<String, Rate> {
        val domainMap = LinkedHashMap<String, Rate> ()
        rates.forEach { rate ->
            domainMap[rate.name!!] = toDomainModel(rate)
        }
        return domainMap
    }
}