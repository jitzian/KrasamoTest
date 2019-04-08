package org.com.raian.krasamocodechallenge.view.custom.layouts

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.com.raian.krasamocodechallenge.R
import java.util.logging.Logger

class LayoutIndicators :LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    private val TAG = LayoutIndicators::class.java.simpleName
    private val logger = Logger.getLogger(TAG)
    private var mTextViewLabel: TextView
    private var mImageViewIcon: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_text_display, this, true)
        mTextViewLabel = findViewById(R.id.mTextViewLabel)
        mImageViewIcon = findViewById(R.id.mImageViewIcon)
    }

    fun setText(text: String) {
        mTextViewLabel.text = text
    }

    fun setImage(type: TypeOfData) {
        when (type) {
            TypeOfData.High -> {
                mImageViewIcon.setImageDrawable(resources.getDrawable(R.drawable.up_arrow_icon))
            }
            TypeOfData.Low -> {
                mImageViewIcon.setImageDrawable(resources.getDrawable(R.drawable.down_arrow_icon))
            }

            else -> logger.info("$TAG::setImage::No image to be displayed")
        }
    }

}