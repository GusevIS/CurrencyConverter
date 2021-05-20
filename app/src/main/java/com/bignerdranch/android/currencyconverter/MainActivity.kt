package com.bignerdranch.android.currencyconverter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.currencyconverter.adapters.RatesRecyclerViewAdapter
import com.bignerdranch.android.currencyconverter.domain.model.Rate
import com.bignerdranch.android.currencyconverter.presenters.LoadRatesPresenter
import com.bignerdranch.android.currencyconverter.views.LoadRatesView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : MvpAppCompatActivity(), LoadRatesView {
    @InjectPresenter
    lateinit var loadRatesPresenter: LoadRatesPresenter

    @ProvidePresenter
    fun provideLoadRatesPresenter() = LoadRatesPresenter(this.applicationContext)

    private lateinit var ratesList: RecyclerView
    private lateinit var adapter: RatesRecyclerViewAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ratesList = findViewById(R.id.rates_recyclerview)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        ratesList.layoutManager = LinearLayoutManager(this)
        ratesList.hasFixedSize()
        adapter = RatesRecyclerViewAdapter(LinkedHashMap(), ratesList)
        ratesList.adapter = adapter
    }

    override fun onPause() {
        loadRatesPresenter.cancelLoading()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        loadRatesPresenter.loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.retry_button -> {
                loadRatesPresenter.cancelLoading()
                loadRatesPresenter.loadData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun updateData(rates: LinkedHashMap<String, Rate>) {
        adapter.updateData(rates)
    }

    override fun noInternetConnectionException() {
        Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show()
    }
}