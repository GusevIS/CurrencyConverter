package com.bignerdranch.android.currencyconverter.data.datasource.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "rate")
data class RateDBEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String?,
    val unit: String?,
    val value: BigDecimal?,
    val type: String?
)
