package com.example.zilongsong.kotlindemo

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.tt.lvruheng.eyepetizer.network.ApiService
import com.tt.lvruheng.eyepetizer.network.RetrofitClient
import com.zl.gank.R
import com.zl.gank.base.BaseFragment
import com.zl.gank.data.ClassificationBean
import com.zl.gank.databinding.HomeFragmentBinding
import com.zl.gank.ui.homefragment.HomeRecyAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Created by zilongsong on 18-4-19.
 */
class HomeFragment : BaseFragment<HomeFragmentBinding>() {


    var mList = ArrayList<ClassificationBean.Result>()
    var mAdapter: HomeRecyAdapter? = null

    override fun getLayoutResources(): Int {
        return R.layout.home_fragment
    }

    @SuppressLint("CheckResult")
    override fun initView() {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        val observable: Observable<ClassificationBean>? = context.let { apiService?.getHomeMoreData("Android", 20, 1) }
        observable?.subscribeOn(Schedulers.io())!!.observeOn(AndroidSchedulers.mainThread())?.subscribe({ result ->
            mList = result.results as ArrayList<ClassificationBean.Result>
            mAdapter?.setData(mList)
            Log.d("Kotlin", result.toString())
        }, { error ->
            error.printStackTrace()
        }, {
            Log.d("Kotlin", "onComplete")
        }, {
            Log.d("Kotlin", "onStart")
        })


        bindingView?.recyclerView?.layoutManager = LinearLayoutManager(context)
        mAdapter = HomeRecyAdapter(context)
        bindingView?.recyclerView?.adapter = mAdapter

    }

}
