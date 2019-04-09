package org.com.raian.krasamocodechallenge.network.rest

import org.com.raian.krasamocodechallenge.network.rest.model.ResultApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {
    @GET("stock/{company}/quote")
    fun fetchStockResultsByCompany(@Path("company")company: String): Call<ResultApi>
}