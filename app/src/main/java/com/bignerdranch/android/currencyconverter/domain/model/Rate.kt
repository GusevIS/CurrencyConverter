package com.bignerdranch.android.currencyconverter.domain.model

import java.math.BigDecimal

data class Rate(
        val unit: String?,
        var value: BigDecimal?,
        val type: String?,
        var calculatedValue: BigDecimal?
        )