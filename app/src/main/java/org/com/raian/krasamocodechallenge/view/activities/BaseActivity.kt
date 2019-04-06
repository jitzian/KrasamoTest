package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import org.com.raian.krasamocodechallenge.view.viewmodel.StockViewModel
import org.com.raian.krasamocodechallenge.view.viewmodel.ViewModelFactory
import java.util.logging.Logger

abstract class BaseActivity : AppCompatActivity() {
    lateinit var TAG: String
    lateinit var logger: Logger
    internal val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory(this)).get(StockViewModel::class.java)
    }

    abstract fun initViews()
}