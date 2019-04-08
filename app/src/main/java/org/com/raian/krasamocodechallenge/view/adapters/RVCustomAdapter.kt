package org.com.raian.krasamocodechallenge.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.com.raian.krasamocodechallenge.R
import org.com.raian.krasamocodechallenge.rest.model.ResultApi
import org.com.raian.krasamocodechallenge.view.custom.layouts.LayoutIndicators
import org.com.raian.krasamocodechallenge.view.custom.layouts.TypeOfData
import java.util.logging.Logger


class RVCustomAdapter(private val context: Context,
//                      private val resultApi: ResultApi,
                      private val lstRes: List<ResultApi>?) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {
    private var TAG: String = RVCustomAdapter::class.java.simpleName
    private var logger: Logger
    private var listOfNewData: List<ResultApi>

    init{
        logger = Logger.getLogger(TAG)
        lstRes.let {
            listOfNewData = it!!
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_card_view, p0, false))
//        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view_company, p0, false))
    }

    override fun getItemCount(): Int {
        return lstRes?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        lstRes?.get(position)?.let {
            logger.severe("$TAG::onBindViewHolder::-->> ${it.symbol}")
            viewHolder.bindData(it)
        }
//        viewHolder.bindData(resultApi)
    }

    fun setData(newData: List<ResultApi>) {
        this.listOfNewData = newData
        notifyDataSetChanged()
    }

//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        private var mTextViewSymbol: TextView
//        private var mTextViewOpen: TextView
//        init{
//            itemView.let {
//                mTextViewSymbol = it.findViewById(R.id.mTextViewSymbol)
//                mTextViewOpen = it.findViewById(R.id.mTextViewOpen)
//            }
//
//        }
//        fun bindData(resultApi: ResultApi){
//            resultApi.symbol?.let {
//                mTextViewSymbol.text = it
//            }
//
//            resultApi.open.let {
//                mTextViewOpen.text = it.toString()
//            }
//        }
//    }


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