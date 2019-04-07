package org.com.raian.krasamocodechallenge.view.fragments

import android.support.v4.app.DialogFragment
import android.view.View
import java.util.logging.Logger

abstract class BaseDialogFragment : DialogFragment() {
    protected lateinit var rootView: View
    protected lateinit var TAG: String
    protected lateinit var logger: Logger
    abstract fun initViews()
}