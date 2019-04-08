package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.util.NetworkReceiver
import org.com.raian.krasamocodechallenge.view.viewmodel.StockViewModel
import org.com.raian.krasamocodechallenge.view.viewmodel.ViewModelFactory
import java.util.logging.Logger

abstract class BaseActivity : AppCompatActivity(), NetworkReceiver.NetworkListener {
    lateinit var TAG: String
    lateinit var logger: Logger
    private lateinit var mSnackBar: Snackbar
    private lateinit var networkReceiver: NetworkReceiver
    internal val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory()).get(StockViewModel::class.java)
    }

    override fun onStart() {
        super.onStart().also {
            networkReceiver = NetworkReceiver(this)
            registerReceiver(networkReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }

    abstract fun initViews()

    override fun onStop() {
        super.onStop().also {
            unregisterReceiver(networkReceiver)
        }
    }

    override fun getNetworkStatus(isConnected: Boolean) {
        showMessage(isConnected)
    }

    private fun showMessage(isConnected: Boolean) {
        if (!isConnected) {
            mSnackBar = Snackbar.make(
                findViewById(R.id.mLayoutMainActivityContainer),
                "There is no Connectivity",
                Snackbar.LENGTH_LONG
            ) //Assume "rootLayout" as the root layout of every activity.
            mSnackBar.duration = Snackbar.LENGTH_LONG
            mSnackBar.show()
        }

    }

}