package com.bignerdranch.android.currencyconverter.presenters

import android.content.Context
import com.bignerdranch.android.currencyconverter.data.repository.RatesRepositoryImpl
import com.bignerdranch.android.currencyconverter.views.LoadRatesView
import moxy.InjectViewState
import moxy.MvpPresenter
import kotlinx.coroutines.*

@InjectViewState
class LoadRatesPresenter(context: Context) : MvpPresenter<LoadRatesView>() {
    private val repository: RatesRepositoryImpl = RatesRepositoryImpl(context)
    private var loadingScope = CoroutineScope(Dispatchers.Main)

    fun loadData() {
        loadingScope.launch {
            var rates = repository.getRatesFromCache()
            if (rates.isNotEmpty()) {
                viewState.updateData(rates)
            }

            while(true) {
                rates = repository.getRates()
                if (rates.isEmpty()) {
                    viewState.noInternetConnectionException()
                    break
                } else {
                    viewState.updateData(rates)
                }
                delay(UPDATE_INTERVAL)
            }
        }
    }

    fun cancelLoading() {
        this.loadingScope.coroutineContext.cancelChildren()
    }

    companion object {
        private const val UPDATE_INTERVAL = 5000L
    }
}