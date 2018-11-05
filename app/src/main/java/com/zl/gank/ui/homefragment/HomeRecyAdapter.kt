package com.zl.gank.ui.homefragment

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zl.gank.R
import com.zl.gank.data.ClassificationBean
import com.zl.gank.databinding.HomeRecyItemBinding

class HomeRecyAdapter(context: Context) : RecyclerView.Adapter<HomeRecyAdapter.HomeViewHolder>() {

    var context: Context? = null
    var list: MutableList<ClassificationBean.Result>? = null

    init {
        this.context = context
    }

    fun setData(list: MutableList<ClassificationBean.Result>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        val dataBinding: HomeRecyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.home_recy_item, parent, false)
        return HomeViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val dataBinding: HomeRecyItemBinding = holder.getBinding()
        dataBinding.result = list?.get(position)
        dataBinding.executePendingBindings()
    }

    class HomeViewHolder(dataBinding: HomeRecyItemBinding) : RecyclerView.ViewHolder(dataBinding.root) {
        var dataBinding: HomeRecyItemBinding

        init {
            this.dataBinding = dataBinding
        }

        fun getBinding(): HomeRecyItemBinding {
            return dataBinding
        }

    }
}