package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.util.safeLet
import org.com.raian.krasamocodechallenge.view.activities.callbacks.ResultsOfRequestedCompanyCallback
import org.com.raian.krasamocodechallenge.view.adapters.RVCustomAdapter
import org.com.raian.krasamocodechallenge.view.fragments.CustomDialogFragment
import java.util.logging.Logger

class MainActivity : BaseActivity(), ResultsOfRequestedCompanyCallback{

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var rvCustomAdapter: RVCustomAdapter
    private lateinit var fabPlusStockCompany: FloatingActionButton

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
        fabPlusStockCompany = findViewById(R.id.fabPlusStockCompany)

        layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume().also {
            fabPlusStockCompany.setOnClickListener {
                CustomDialogFragment().show(supportFragmentManager, CustomDialogFragment::class.java.simpleName)
            }
        }
    }

    override fun companyRequested(company: String) {
        logger.severe("$TAG::company::$company")
        viewModel.fetchStockResultsByCompany(company)
        viewModel.getDetailsOfCompany().observe(this, Observer { result ->
            logger.severe("$TAG::$result")
            safeLet(this, result){ ctx, res ->
                rvCustomAdapter = RVCustomAdapter(ctx, res)
                mRecyclerView.adapter = rvCustomAdapter
            }
        })
    }


}
