package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.view.viewmodel.StockViewModel
import org.com.raian.krasamocodechallenge.view.viewmodel.ViewModelFactory
import java.util.logging.Logger

class MainActivity : BaseActivity() {
    private lateinit var viewModel: StockViewModel
    init {
        TAG = MainActivity::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            setContentView(R.layout.activity_main)
            initViews()
        }
    }

    override fun initViews() {
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(StockViewModel::class.java)
    }

    override fun onResume() {
        super.onResume().also {
            viewModel.fetchStockResultsByCompany("FB")
        }
    }
}
