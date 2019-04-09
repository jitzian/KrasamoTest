package org.com.raian.krasamocodechallenge.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.view.activities.callbacks.ResultsOfRequestedCompanyCallback
import java.util.logging.Logger


class CustomDialogFragment : BaseDialogFragment() {
    private lateinit var mEditTextNewStockSymbol: EditText
    private lateinit var mButtonOk: Button
    private lateinit var callback: ResultsOfRequestedCompanyCallback

    override fun onAttach(context: Context) {
        super.onAttach(context).also {
            TAG = CustomDialogFragment::class.java.simpleName
            logger = Logger.getLogger(TAG)

            if (activity is ResultsOfRequestedCompanyCallback) {
                callback = activity as ResultsOfRequestedCompanyCallback
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        initViews()
        dialog?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        )
        return rootView
    }

    override fun initViews() {
        mEditTextNewStockSymbol = rootView.findViewById(R.id.mEditTextNewStockSymbol)
        mButtonOk = rootView.findViewById(R.id.mButtonOk)
    }

    override fun onResume() {
        //Setting size of the dialog fragment
        dialog?.window?.setLayout(
            resources.getDimensionPixelSize(R.dimen.popup_width),
            resources.getDimensionPixelSize(R.dimen.popup_height)
        )

        super.onResume().also {
            mButtonOk.setOnClickListener { view ->
                if (!mEditTextNewStockSymbol.text.isNullOrEmpty()) {
                    callback.companyRequested(mEditTextNewStockSymbol.text.toString())
                    this.dismiss()
                }
            }
        }
    }

}
