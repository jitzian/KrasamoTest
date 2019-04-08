package org.com.raian.krasamocodechallenge.view.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
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

class StockViewModel : BaseViewModel() {
    private lateinit var restApi: RestApi
    @Inject
    lateinit var retrofit: Retrofit

    //This variable is for giving update to UI about the request that is performed
    private val statusOfResponse by lazy {
        MutableLiveData<Boolean>()
    }

    private val lstRes = ArrayList<ResultApi>()

    private val listOfCompanies by lazy {
        MutableLiveData<List<ResultApi>>()
    }

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

    fun fetchStockResultsByCompany(companyName: String) = GlobalScope.launch(Dispatchers.IO) {
        restApi = retrofit.create(RestApi::class.java)
        restApi.fetchStockResultsByCompany(companyName).enqueue(object: Callback<ResultApi>{

            override fun onFailure(call: Call<ResultApi>, t: Throwable) {
                logger.severe("$TAG::fetchStockResultsByCompany::onFailure::${t.message}")
                statusOfResponse.value = false
            }

            override fun onResponse(call: Call<ResultApi>, response: Response<ResultApi>) {
                logger.info("$TAG::fetchStockResultsByCompany::onResponse::${response.body()?.high.toString()}")
                response.body()?.let {
                    if(lstRes.contains(it)){
                        lstRes.remove(it)
                        lstRes.add(it)
                        listOfCompanies.value = lstRes
                    }else{
                        lstRes.add(it)
                        listOfCompanies.value = lstRes
                    }
                }
                statusOfResponse.value = response.body() != null
            }
        })
    }


    fun getStatusOfResponse(): LiveData<Boolean>{
        return statusOfResponse
    }

    fun getListOfCompanies(): LiveData<List<ResultApi>>{
        return listOfCompanies
    }

}