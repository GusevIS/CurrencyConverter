package com.bignerdranch.android.currencyconverter.adapters.utils

import com.bignerdranch.android.currencyconverter.R

interface ImageLoader {
    companion object {
        fun getImageByRateName(rateName: String?): Int {
            return when (rateName) {
                // crypto
                "Bitcoin" -> R.mipmap.btc
                "Ether" -> R.mipmap.eth
                "Litecoin" -> R.mipmap.ltc
                "Bitcoin Cash" -> R.mipmap.bch
                "Binance Coin" -> R.mipmap.bnb
                "EOS" -> R.mipmap.eos
                "XRP" -> R.mipmap.xrp
                "Lumens" -> R.mipmap.xlm
                "Chainlink" -> R.mipmap.link
                "Polkadot" -> R.mipmap.dot
                "Yearn.finance" -> R.mipmap.yfi

                // fiat
                "US Dollar" -> R.mipmap.us_dollar
                "United Arab Emirates Dirham" -> R.mipmap.united_arab_emirates
                "Argentine Peso" -> R.mipmap.argentina
                "Australian Dollar" -> R.mipmap.australia
                "Bangladeshi Taka" -> R.mipmap.bangladesh
                "Bahraini Dinar" -> R.mipmap.bahrain
                "Bermudian Dollar" -> R.mipmap.bermuda
                "Brazil Real" -> R.mipmap.brazil
                "Canadian Dollar" -> R.mipmap.canada
                "Swiss Franc" -> R.mipmap.switzerland
                "Chilean Peso" -> R.mipmap.chile
                "Chinese Yuan" -> R.mipmap.china
                "Czech Koruna" -> R.mipmap.czech
                "Danish Krone" -> R.mipmap.denmark
                "Euro" -> R.mipmap.europe
                "British Pound Sterling" -> R.mipmap.united_kingdom
                "Hong Kong Dollar" -> R.mipmap.hong_kong
                "Hungarian Forint" -> R.mipmap.hungary
                "Indonesian Rupiah" -> R.mipmap.indonesia
                "Israeli New Shekel" -> R.mipmap.israel
                "Indian Rupee" -> R.mipmap.india
                "Japanese Yen" -> R.mipmap.japan
                "South Korean Won" -> R.mipmap.south_korea
                "Kuwaiti Dinar" -> R.mipmap.kuwait
                "Sri Lankan Rupee" -> R.mipmap.sri_lanka
                "Burmese Kyat" -> R.mipmap.myanmar
                "Mexican Peso" -> R.mipmap.mexico
                "Malaysian Ringgit" -> R.mipmap.malaysia
                "Nigerian Naira" -> R.mipmap.nigeria
                "Norwegian Krone" -> R.mipmap.norway
                "New Zealand Dollar" -> R.mipmap.new_zealand
                "Philippine Peso" -> R.mipmap.philippines
                "Pakistani Rupee" -> R.mipmap.pakistan
                "Polish Zloty" -> R.mipmap.poland
                "Russian Ruble" -> R.mipmap.russia
                "Saudi Riyal" -> R.mipmap.saudi_arabia
                "Swedish Krona" -> R.mipmap.sweden
                "Singapore Dollar" -> R.mipmap.singapore
                "Thai Baht" -> R.mipmap.thailand
                "Turkish Lira" -> R.mipmap.turkey
                "New Taiwan Dollar" -> R.mipmap.taiwan
                "Ukrainian hryvnia" -> R.mipmap.ukraine
                "Venezuelan bolívar fuerte" -> R.mipmap.venezuela
                "Vietnamese đồng" -> R.mipmap.vietnam
                "South African Rand" -> R.mipmap.south_africa

                else -> R.mipmap.nopic
            }
        }
    }
}