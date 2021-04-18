package com.bignerdranch.android.currencyconverter.adapters

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.currencyconverter.R
import com.bignerdranch.android.currencyconverter.models.Rates
import com.bignerdranch.android.currencyconverter.utils.RatesRounder
import java.math.BigDecimal
import kotlin.collections.ArrayList

class RatesRecyclerViewAdapter(private var values: Rates, private var recyclerView: RecyclerView?):
        RecyclerView.Adapter<RatesRecyclerViewAdapter.RateViewHolder>() {
    private var rateUnits: ArrayList<String> = ArrayList(values.rates.keys)

    class RateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var shortNameTextView: TextView? = null
        var fullNameTextView: TextView? = null
        var valueEditText: EditText? = null

        init {
            shortNameTextView = itemView.findViewById(R.id.text_rate_short_name_item)
            fullNameTextView = itemView.findViewById(R.id.text_rate_full_name_item)
            valueEditText = itemView.findViewById(R.id.edit_rate_value)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.rate_item, parent, false)

        return RateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.shortNameTextView?.text = values.rates[rateUnits[position]]?.unit
        holder.fullNameTextView?.text = rateUnits[position]
        holder.valueEditText?.setText(values.rates[rateUnits[position]]?.calculatedValue.toString())

        holder.valueEditText?.setOnFocusChangeListener { v, hasFocus ->
            if(holder.adapterPosition != RecyclerView.NO_POSITION){
                if(holder.adapterPosition != 0){
                    swapItems(holder.adapterPosition)
                }
            }
        }

        holder.valueEditText?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                if(holder.adapterPosition == 0){
                    val newCurrencyString = holder.valueEditText?.text.toString()
                    val newCurrency: BigDecimal = if(newCurrencyString.isEmpty()) {
                        BigDecimal.valueOf(0.0)
                    } else
                        newCurrencyString.toBigDecimal().setScale(2,
                                BigDecimal.ROUND_HALF_EVEN)

                    values.rates[rateUnits[holder.adapterPosition]]?.calculatedValue = newCurrency
                    recountRates(newCurrency,
                            values.rates[rateUnits[holder.adapterPosition]]?.value)
                }
            }
        })
    }

    override fun getItemCount(): Int = values.rates.size

    private fun recountRates(newCurrency: BigDecimal?, currentCurrencyRate: BigDecimal?) {
        for (i in 1 until rateUnits.size) {

            val coefficient = values.rates[rateUnits[i]]?.value!!.divide(currentCurrencyRate,
                    10, BigDecimal.ROUND_HALF_EVEN)
            val calculatedRate = coefficient * newCurrency!!

            values.rates[rateUnits[i]]?.calculatedValue =
                    RatesRounder.roundOffRate(calculatedRate, values.rates[rateUnits[i]]?.type!!)
        }

        recyclerView?.post(Runnable {
           notifyItemRangeChanged(1, rateUnits.size - 1)
        })
    }

    fun updateData(newRates: Rates) {
        if(this.values.rates.isEmpty()) {
            this.rateUnits = ArrayList(newRates.rates.keys)
            this.values = newRates
            for(i in 0 until rateUnits.size){
                this.values.rates[rateUnits[i]]?.calculatedValue =
                        RatesRounder.roundOffRate(newRates.rates[rateUnits[i]]?.calculatedValue!!,
                                newRates.rates[rateUnits[i]]?.type!!)
            }
            notifyDataSetChanged()
        }
        else {
            for (i in 0 until rateUnits.size) {
                this.values.rates[rateUnits[i]]?.value = newRates.rates[rateUnits[i]]?.value
            }
            recountRates(this.values.rates[rateUnits[0]]?.calculatedValue,
                    this.values.rates[rateUnits[0]]?.value)
        }
    }

    private fun swapItems(fromPosition: Int) {
        rateUnits.add(0, rateUnits.removeAt(fromPosition))
        notifyItemMoved(fromPosition, 0)
    }
}