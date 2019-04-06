package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.util.safeLet
import org.com.raian.krasamocodechallenge.view.adapters.RVCustomAdapter
import java.util.logging.Logger

class MainActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var rvCustomAdapter: RVCustomAdapter

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
        mRecyclerView = findViewById(R.id.mRecyclerView)
        layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume().also {
            viewModel.fetchStockResultsByCompany("FB")
            viewModel.getDetailsOfCompany().observe(this, Observer { result ->
                logger.severe("$TAG::$result")
                safeLet(this, result){ ctx, res ->
                    rvCustomAdapter = RVCustomAdapter(ctx, res)
                    mRecyclerView.adapter = rvCustomAdapter
                }
            })
        }
    }
}
