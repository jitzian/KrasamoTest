package org.com.raian.krasamocodechallenge.view.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.util.safeLet
import org.com.raian.krasamocodechallenge.view.activities.callbacks.ResultsOfRequestedCompanyCallback
import org.com.raian.krasamocodechallenge.view.adapters.RVCustomAdapter
import org.com.raian.krasamocodechallenge.view.fragments.CustomDialogFragment
import java.util.logging.Logger

class MainActivity : BaseActivity(), ResultsOfRequestedCompanyCallback {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var rvCustomAdapter: RVCustomAdapter
    private var listOfInputCompanies = mutableListOf<String>()

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

            viewModel.getStatusOfResponse().observe(this, Observer { isResponseSuccessful ->
                isResponseSuccessful.let {
                    if (it == false) {
                        Snackbar
                            .make(
                                findViewById(R.id.mLayoutMainActivityContainer),
                                "Company not found",
                                Snackbar.LENGTH_LONG
                            )
                            .setAction("Dismiss", null)
                            .show()
                    }
                }
            })

        }
    }

    override fun companyRequested(inputCompany: String) {
        listOfInputCompanies.add(inputCompany)

        viewModel.fetchStockResultsByCompany(inputCompany)
        viewModel.getListOfCompanies().observe(this, Observer { result ->
            safeLet(this, result) { ctx, res ->
                rvCustomAdapter = RVCustomAdapter(ctx, res)
                mRecyclerView.adapter = rvCustomAdapter

            }
        })
    }

}
