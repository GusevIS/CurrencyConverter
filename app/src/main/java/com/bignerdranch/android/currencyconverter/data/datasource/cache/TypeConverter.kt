package com.bignerdranch.android.currencyconverter.data.datasource.cache

import androidx.room.TypeConverter
import java.math.BigDecimal

class RateDBConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromBigDecimal(value: BigDecimal): String {
            return value.toString()
        }

        @TypeConverter
        @JvmStatic
        fun toBigDecimal(value: String): BigDecimal {
            return value.toBigDecimal()
        }
    }
}