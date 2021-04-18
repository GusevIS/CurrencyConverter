package com.bignerdranch.android.currencyconverter

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.currencyconverter.adapters.RatesRecyclerViewAdapter
import com.bignerdranch.android.currencyconverter.models.Rates
import com.bignerdranch.android.currencyconverter.models.Rate
import com.bignerdranch.android.currencyconverter.presenters.LoadRatesPresenter
import com.bignerdranch.android.currencyconverter.views.LoadRatesView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : MvpAppCompatActivity(), LoadRatesView{
    @InjectPresenter
    lateinit var loadRatesPresenter: LoadRatesPresenter

    @ProvidePresenter
    fun provideLoadRatesPresenter() = LoadRatesPresenter()

    private lateinit var ratesList: RecyclerView
    private lateinit var adapter: RatesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratesList = findViewById(R.id.rates_recyclerview)

        ratesList.layoutManager = LinearLayoutManager(this)
        ratesList.hasFixedSize()
        adapter = RatesRecyclerViewAdapter(Rates(LinkedHashMap<String, Rate>()), ratesList)
        ratesList.adapter = adapter

        loadRatesPresenter.loadData()
    }

    override fun updateData(rates: Rates) {
        adapter.updateData(rates)
    }

    override fun noInternetConnectionException() {
        Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show()
    }
}