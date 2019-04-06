package org.com.raian.krasamocodechallenge.view.activities

import android.support.v7.app.AppCompatActivity
import java.util.logging.Logger

abstract class BaseActivity: AppCompatActivity() {
    lateinit var TAG: String
    lateinit var logger: Logger

    abstract fun initViews()
}