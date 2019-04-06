package org.com.raian.krasamocodechallenge.view.activities

import android.os.Bundle
import org.com.raian.krasamocodechallenge.R
import java.util.logging.Logger

class MainActivity : BaseActivity() {

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
        }
    }
}
