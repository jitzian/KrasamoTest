package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import org.com.raian.krasamocodechallenge.R
import java.util.logging.Logger

class MainActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView

    init {
        TAG = MainActivity::class.java.simpleName
        logger = Logger.getLogger(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            setContentView(R.layout.activity_main)
        }
    }

    override fun onResume() {
        super.onResume().also {
            viewModel.fetchStockResultsByCompany("FB")
            viewModel.getDetailsOfCompany().observe(this, Observer { result ->
                logger.severe("$TAG::$result")
            })
        }
    }
}
