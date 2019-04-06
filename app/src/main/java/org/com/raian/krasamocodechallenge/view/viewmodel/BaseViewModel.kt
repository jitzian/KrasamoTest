package org.com.raian.krasamocodechallenge.view.viewmodel

import android.arch.lifecycle.ViewModel
import java.util.logging.Logger

abstract class BaseViewModel: ViewModel(){
    lateinit var logger: Logger
    lateinit var TAG: String
}