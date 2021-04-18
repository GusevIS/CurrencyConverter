package com.bignerdranch.android.currencyconverter.presenters

import com.bignerdranch.android.currencyconverter.api.CoingeckoApi
import com.bignerdranch.android.currencyconverter.views.LoadRatesView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import moxy.InjectViewState
import moxy.MvpPresenter
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

@InjectViewState
class LoadRatesPresenter(): MvpPresenter<LoadRatesView>() {
    private var api: CoingeckoApi = CoingeckoApi.create()

    fun loadData(){
        api.loadRates()
                .subscribeOn(io())
                .repeatWhen { completed -> completed.delay(UPDATE_INTERVAL, TimeUnit.SECONDS) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    viewState.updateData(result)
                }, { error ->
                    error.printStackTrace()
                    viewState.noInternetConnectionException()
                })
    }

    companion object {
        private const val UPDATE_INTERVAL = 5L
    }
}