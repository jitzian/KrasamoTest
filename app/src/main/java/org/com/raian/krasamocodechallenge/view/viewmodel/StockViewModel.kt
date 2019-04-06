package org.com.raian.krasamocodechallenge.view.viewmodel

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.com.raian.krasamocodechallenge.dependency.injection.components.DaggerComponentInjector
import org.com.raian.krasamocodechallenge.dependency.injection.modules.NetworkModule
import org.com.raian.krasamocodechallenge.rest.RestApi
import org.com.raian.krasamocodechallenge.rest.model.ResultApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject

class StockViewModel(context: Context) : BaseViewModel() {
    private lateinit var restApi: RestApi
    @Inject
    lateinit var retrofit: Retrofit

    private val injector = DaggerComponentInjector
        .builder()
        .networkModule(NetworkModule())
        .build()

    init {
        TAG = StockViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject(){
        injector.inject(this)
    }

    fun fetchStockResultsByCompany(company: String) = GlobalScope.launch(Dispatchers.IO) {
        restApi = retrofit.create(RestApi::class.java)
        restApi.fetchStockResultsByCompany(company).enqueue(object: Callback<ResultApi>{
            override fun onFailure(call: Call<ResultApi>, t: Throwable) {
                logger.severe("$TAG::fetchStockResultsByCompany::onFailure::${t.message}")
            }

            override fun onResponse(call: Call<ResultApi>, response: Response<ResultApi>) {
                logger.severe("$TAG::fetchStockResultsByCompany::onResponse::${response.body()?.high.toString()}")
            }

        })
    }


}