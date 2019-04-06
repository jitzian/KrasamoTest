package org.com.raian.krasamocodechallenge.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.rest.model.ResultApi
import org.com.raian.krasamocodechallenge.view.custom.layouts.LayoutIndicators
import org.com.raian.krasamocodechallenge.view.custom.layouts.TypeOfData

class RVCustomAdapter(private val context: Context, private val resultApi: ResultApi) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_card_view, p0, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindData(resultApi)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var mLayoutIndicatorSymbol: LayoutIndicators
        private var mLayoutIndicatorOpen: LayoutIndicators
        private var mLayoutIndicatorHigh: LayoutIndicators
        private var mLayoutIndicatorLow: LayoutIndicators

        init {
            itemView.let {
                mLayoutIndicatorSymbol = it.findViewById(R.id.mLayoutIndicatorSymbol)
                mLayoutIndicatorOpen = it.findViewById(R.id.mLayoutIndicatorOpen)
                mLayoutIndicatorHigh = it.findViewById(R.id.mLayoutIndicatorHigh)
                mLayoutIndicatorLow = it.findViewById(R.id.mLayoutIndicatorLow)
            }
        }

        fun bindData(resultApi: ResultApi) {

            resultApi.symbol?.let {
                mLayoutIndicatorSymbol.setText(it)
            }

            resultApi.open.let {
                mLayoutIndicatorOpen.setText(it.toString())
            }

            resultApi.high.let {
                mLayoutIndicatorHigh.setText(it.toString())
                mLayoutIndicatorHigh.setImage(TypeOfData.High)
            }

            resultApi.low.let {
                mLayoutIndicatorLow.setText(it.toString())
                mLayoutIndicatorLow.setImage(TypeOfData.Low)
            }

        }

    }

}