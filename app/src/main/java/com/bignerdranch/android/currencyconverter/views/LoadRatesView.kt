package com.bignerdranch.android.currencyconverter.views

import com.bignerdranch.android.currencyconverter.models.Rates
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface LoadRatesView: MvpView {
    fun updateData(rates: Rates)
    fun noInternetConnectionException()
}