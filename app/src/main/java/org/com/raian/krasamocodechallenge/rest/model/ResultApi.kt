package org.com.raian.krasamocodechallenge.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultApi {

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
    @SerializedName("companyName")
    @Expose
    var companyName: String? = null
    @SerializedName("primaryExchange")
    @Expose
    var primaryExchange: String? = null
    @SerializedName("sector")
    @Expose
    var sector: String? = null
    @SerializedName("calculationPrice")
    @Expose
    var calculationPrice: String? = null
    @SerializedName("open")
    @Expose
    var open: Double = 0.toDouble()
    @SerializedName("openTime")
    @Expose
    var openTime: Int = 0
    @SerializedName("close")
    @Expose
    var close: Double = 0.toDouble()
    @SerializedName("closeTime")
    @Expose
    var closeTime: Int = 0
    @SerializedName("high")
    @Expose
    var high: Int = 0
    @SerializedName("low")
    @Expose
    var low: Double = 0.toDouble()
    @SerializedName("latestPrice")
    @Expose
    var latestPrice: Double = 0.toDouble()
    @SerializedName("latestSource")
    @Expose
    var latestSource: String? = null
    @SerializedName("latestTime")
    @Expose
    var latestTime: String? = null
    @SerializedName("latestUpdate")
    @Expose
    var latestUpdate: Int = 0
    @SerializedName("latestVolume")
    @Expose
    var latestVolume: Int = 0
    @SerializedName("iexRealtimePrice")
    @Expose
    var iexRealtimePrice: Double = 0.toDouble()
    @SerializedName("iexRealtimeSize")
    @Expose
    var iexRealtimeSize: Int = 0
    @SerializedName("iexLastUpdated")
    @Expose
    var iexLastUpdated: Int = 0
    @SerializedName("delayedPrice")
    @Expose
    var delayedPrice: Double = 0.toDouble()
    @SerializedName("delayedPriceTime")
    @Expose
    var delayedPriceTime: Int = 0
    @SerializedName("extendedPrice")
    @Expose
    var extendedPrice: Double = 0.toDouble()
    @SerializedName("extendedChange")
    @Expose
    var extendedChange: Double = 0.toDouble()
    @SerializedName("extendedChangePercent")
    @Expose
    var extendedChangePercent: Double = 0.toDouble()
    @SerializedName("extendedPriceTime")
    @Expose
    var extendedPriceTime: Int = 0
    @SerializedName("previousClose")
    @Expose
    var previousClose: Double = 0.toDouble()
    @SerializedName("change")
    @Expose
    var change: Double = 0.toDouble()
    @SerializedName("changePercent")
    @Expose
    var changePercent: Double = 0.toDouble()
    @SerializedName("iexMarketPercent")
    @Expose
    var iexMarketPercent: Double = 0.toDouble()
    @SerializedName("iexVolume")
    @Expose
    var iexVolume: Int = 0
    @SerializedName("avgTotalVolume")
    @Expose
    var avgTotalVolume: Int = 0
    @SerializedName("iexBidPrice")
    @Expose
    var iexBidPrice: Int = 0
    @SerializedName("iexBidSize")
    @Expose
    var iexBidSize: Int = 0
    @SerializedName("iexAskPrice")
    @Expose
    var iexAskPrice: Int = 0
    @SerializedName("iexAskSize")
    @Expose
    var iexAskSize: Int = 0
    @SerializedName("marketCap")
    @Expose
    var marketCap: Int = 0
    @SerializedName("peRatio")
    @Expose
    var peRatio: Double = 0.toDouble()
    @SerializedName("week52High")
    @Expose
    var week52High: Double = 0.toDouble()
    @SerializedName("week52Low")
    @Expose
    var week52Low: Double = 0.toDouble()
    @SerializedName("ytdChange")
    @Expose
    var ytdChange: Double = 0.toDouble()

}
