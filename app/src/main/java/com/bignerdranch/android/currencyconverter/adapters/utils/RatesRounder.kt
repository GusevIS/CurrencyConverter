package com.bignerdranch.android.currencyconverter.adapters.utils

import java.math.BigDecimal

class RatesRounder {
    companion object {
        fun roundOffRate(rate: BigDecimal, currencyType: String): BigDecimal {
            return if (currencyType == "fiat") {
                rate.setScale(2, BigDecimal.ROUND_HALF_EVEN)
            } else {
                rate.setScale(3, BigDecimal.ROUND_HALF_EVEN)
            }
        }
    }
}