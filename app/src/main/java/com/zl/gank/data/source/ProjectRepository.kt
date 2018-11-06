package com.zl.gank.data.source

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.zl.gank.data.ClassificationBean
import java.math.BigDecimal
import androidx.lifecycle.MutableLiveData
import com.tt.lvruheng.eyepetizer.network.ApiService
import com.tt.lvruheng.eyepetizer.network.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList


class ProjectRepository {

    @SuppressLint("CheckResult")
    fun getTodayList(context: Context, type: String, size: Int, page: Int): LiveData<List<ClassificationBean.Result>> {
        val data = MutableLiveData<List<ClassificationBean.Result>>()
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        val observable: Observable<ClassificationBean>? = context.let { apiService?.getHomeMoreData("Android", 20, 1) }
        observable?.subscribeOn(Schedulers.io())!!.observeOn(AndroidSchedulers.mainThread())?.subscribe({ result ->
            data.value = result.results
            Log.d("Kotlin", result.toString())
        }, { error ->
            error.printStackTrace()
        }, {
            Log.d("Kotlin", "onComplete")
        }, {
            Log.d("Kotlin", "onStart")
        })

        return data
    }
}