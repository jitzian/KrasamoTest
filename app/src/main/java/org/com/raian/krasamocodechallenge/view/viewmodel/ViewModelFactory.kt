package org.com.raian.krasamocodechallenge.view.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StockViewModel::class.java)){
            return StockViewModel(context) as T
        }
        throw IllegalArgumentException("ViewModel class is not defined")
    }
}