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
    var openTime: Double = 0.toDouble()
    @SerializedName("close")
    @Expose
    var close: Double = 0.toDouble()
    @SerializedName("closeTime")
    @Expose
    var closeTime: Double = 0.toDouble()
    @SerializedName("high")
    @Expose
    var high: Double = 0.toDouble()
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
    var latestUpdate: Double = 0.toDouble()
    @SerializedName("latestVolume")
    @Expose
    var latestVolume: Double = 0.toDouble()
    @SerializedName("iexRealtimePrice")
    @Expose
    var iexRealtimePrice: Double = 0.toDouble()
    @SerializedName("iexRealtimeSize")
    @Expose
    var iexRealtimeSize: Double = 0.toDouble()
    @SerializedName("iexLastUpdated")
    @Expose
    var iexLastUpdated: Double = 0.toDouble()
    @SerializedName("delayedPrice")
    @Expose
    var delayedPrice: Double = 0.toDouble()
    @SerializedName("delayedPriceTime")
    @Expose
    var delayedPriceTime: Double = 0.toDouble()
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
    var extendedPriceTime: Double = 0.toDouble()
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
    var iexVolume: Double = 0.toDouble()
    @SerializedName("avgTotalVolume")
    @Expose
    var avgTotalVolume: Double = 0.toDouble()
    @SerializedName("iexBidPrice")
    @Expose
    var iexBidPrice: Double = 0.toDouble()
    @SerializedName("iexBidSize")
    @Expose
    var iexBidSize: Double = 0.toDouble()
    @SerializedName("iexAskPrice")
    @Expose
    var iexAskPrice: Double = 0.toDouble()
    @SerializedName("iexAskSize")
    @Expose
    var iexAskSize: Double = 0.toDouble()
    @SerializedName("marketCap")
    @Expose
    var marketCap: Double = 0.toDouble()
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